package com.example.back_end.controller;

import com.example.back_end.config.JwtTokenUtil;
import com.example.back_end.config.JwtUserDetails;
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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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


    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> loginAuthentication(@RequestBody JwtRequest authenticationRequest) throws Exception {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            JwtUserDetails principal = (JwtUserDetails) authentication.getPrincipal();
            GrantedAuthority authority = principal.getAuthorities().stream().findFirst().orElse(null);
            final String token = jwtTokenUtil.generateToken(principal.getUsername());

            return ResponseEntity.ok(new JwtResponse(token, principal.getUsername(), authority != null ? authority.getAuthority() : null));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Đăng nhập thất bại");
        }
//        Users users = usersService.findByUsername(authenticationRequest.getUsername());
//        final UserDetails userDetails = usersService.loadUserByUsername(authenticationRequest.getUsername());
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
                emailService.sendMail(users.getEmail(), "Mã xác nhận email", "Chào bạn,Mã xác thực email trong quy trình lấy lại mật khẩu của bạn:" + randomNumber +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "---------------------------------------" + "\n" +
                        "Name :Pawn Shop\n" +
                        "Mobile : 0782391943\n" +
                        "Email : pawnshopC0123@gmail.com\n" +
                        "Address :\u200B2\u200B80\u200B \u200BTrần Hưng Đạo\u200B streets, \u200BSơn Trà\u200B District, Da Nang");
            } catch (Exception e) {

            }
            return ResponseEntity.ok(users.getId());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email không đúng!!");
        }
    }

    @PostMapping("/checkCode")
    public ResponseEntity<?> checkCode(@RequestBody Users user) {
        Users users = usersService.findById(user.getId());
        if (users.getVerificationCode().toString().equals(user.getVerificationCode().toString())) {
            return ResponseEntity.ok(users.getId());
        } else {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Xác nhận mã thất bại!!");
        }
    }

    @PatchMapping("/newPassword")
    public ResponseEntity<?> createNewPassword(@RequestBody Users user) {
        if (user.getPassword().length() < 8 || user.getPassword().length() > 20) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Mật khẩu không được ít hơn 8 hoăc nhiều hơn 50 kí tự!!");
        }
        try {
            usersService.saveNewPassword(user);
            return ResponseEntity.ok("Đổi mật khẩu thành công!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Đổi mật khẩu thất bại!!");
        }
    }
}