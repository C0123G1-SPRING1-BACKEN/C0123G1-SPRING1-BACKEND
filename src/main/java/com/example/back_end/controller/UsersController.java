package com.example.back_end.controller;

import com.example.back_end.config.JwtTokenUtil;
import com.example.back_end.model.Users;
import com.example.back_end.reponse.JwtRequest;
import com.example.back_end.reponse.JwtResponse;
import com.example.back_end.service.impl.EmailService;
import com.example.back_end.service.impl.UsersService;
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
    class ErrorInfo {
        private String error;
        private Long id;

        public ErrorInfo(String error, Long id) {
            this.error = error;
            this.id = id;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }
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
        final String token = jwtTokenUtil.generateToken(userDetails.getUsername(), users.getRoles().getRoleName(), users.getId());

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/checkEmail")
    public ResponseEntity<?> checkMail(@RequestBody Users user) {
        Users users = usersService.findByEmail(user.getEmail());
        if (users != null) {
            Random random = new Random();
            int randomNumber = random.nextInt(900000) + 100000;
            users.setVerificationCode(randomNumber);
            try {
                usersService.editUser(users);
                emailService.sendMail(users.getEmail(), "Mã xác nhận email", "Mã:" + randomNumber);
            } catch (Exception e) {

            }
            return ResponseEntity.ok(users.getId());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email không tồn tại!!");
        }
    }

    @PostMapping("/checkCode")
    public ResponseEntity<?> checkCode(@RequestBody Users user) {
        Users users = usersService.findById(user.getId());
        if (users.getVerificationCode().toString().equals(user.getVerificationCode().toString())) {
            return ResponseEntity.ok(users.getId());
        } else {

            ErrorInfo errorInfo = new ErrorInfo("Xác nhận mã thất bại!!", users.getId());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorInfo);
        }
    }

    @PatchMapping("/newPassword")
    public ResponseEntity<?> createNewPassword(@RequestBody Users user) {
        if (user.getPassword().length() < 8 || user.getPassword().length() > 20) {
            ErrorInfo errorInfo=new ErrorInfo("Mật khẩu không được ít hơn 8 hoăc lớn hơn 20 kí tự!!",user.getId());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorInfo);
        }
        try {
            usersService.saveNewPassword(user);
            return ResponseEntity.ok("Đổi mật khẩu thành công!");
        } catch (Exception e) {
            ErrorInfo errorInfo=new ErrorInfo("Đổi mật khẩu thất bại!!",user.getId());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorInfo);
        }
    }
}
