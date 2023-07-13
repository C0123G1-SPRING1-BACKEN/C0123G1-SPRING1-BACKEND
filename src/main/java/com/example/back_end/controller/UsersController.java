package com.example.back_end.controller;

import com.example.back_end.config.JwtTokenUtil;
import com.example.back_end.model.Users;
import com.example.back_end.reponse.JwtRequest;
import com.example.back_end.reponse.JwtResponse;
import com.example.back_end.service.impl.UsersService;
import com.example.back_end.service.impl.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
/**
 * Created by: VienH
 * Date created: 13/07/2023
 * Function: Login , Forgot Password
 *
 * @param 
 * @return
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UsersController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UsersService usersService;
    @Autowired
    private EmailService emailService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> loginAuthentication(@RequestBody JwtRequest authenticationRequest) throws Exception {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        Users users = usersService.findByUsername(authenticationRequest.getUsername());
        final UserDetails userDetails = usersService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails.getUsername(), users.getRoles().getRoleName());

        return ResponseEntity.ok(new JwtResponse(token));
    }
    @PostMapping("/checkEmail")
    public ResponseEntity<?> checkMail(@RequestBody Users user) {
        Users users=usersService.findByEmail(user.getEmail());
        if (users != null){
            Random random = new Random();
            int randomNumber = random.nextInt(900000) + 100000;
            users.setVerificationCode(randomNumber);
            try {
                usersService.editUser(users);
                emailService.sendMail(users.getEmail(),"Mã xác nhận email","Mã:"+randomNumber);
            }catch (Exception e){

            }
            return ResponseEntity.ok(users.getId());
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email không tồn tại!!");
        }
    }
    @PostMapping("checkCode")
    public ResponseEntity<?> checkCode(@RequestBody Users user){
        Users users=usersService.findById(user.getId());
        if (users.getVerificationCode() == user.getVerificationCode()){
            return ResponseEntity.ok(users.getId());
        }else {
            class ErrorInfo {
                private String error;
                private Long id;

                public ErrorInfo(String error, Long id) {
                    this.error = error;
                    this.id = id;
                }

                // getters and setters
            }
            ErrorInfo errorInfo=new ErrorInfo("Xác nhận mã thất bại!!",users.getId());
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorInfo);
        }
    }
    @PostMapping("/newPassword")
    public ResponseEntity<?> createNewPassword(@RequestBody Users user){
        try {
            usersService.saveNewPassword(user);
            return ResponseEntity.ok("Đổi mật khẩu thành công!");
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Đổi mật khẩu thất bại!!");
        }
    }
}
