package com.example.back_end.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtTokenUtil {

    private static final long JWT_TOKEN_VALIDITY = 18000;

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(String username, String role) {

        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + JWT_TOKEN_VALIDITY * 1000);

        return Jwts.builder()
//                .setClaims(claims)
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, this.secret) // Sử dụng khóa để ký JWT token
                .compact();
    }


    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(this.secret)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String token, JwtUserDetails userDetails)  {
        try {
            JwtParser parser = Jwts.parser().setSigningKey(secret);
            Claims claims = parser.parseClaimsJws(token).getBody();

            // Kiểm tra tính hợp lệ của token bằng cách so sánh username trong token với thông tin người dùng được truyền vào
            if (claims.getSubject().equals(userDetails.getUsername())) {
                return true;
            }
        } catch (Exception e) {
            // Xử lý ngoại lệ nếu có

        }

        return false;
    }

}