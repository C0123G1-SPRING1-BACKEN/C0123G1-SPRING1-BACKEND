package com.example.back_end.service.impl;

import com.example.back_end.service.IJWTAuthorization;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

@Service
public class JWTAuthorization implements IJWTAuthorization {

    @Override
    public boolean isAdminUser(String authorizationHeader) {
        String token = authorizationHeader.replace("Bearer ", "");
        Claims claims = Jwts.parser()
                .setSigningKey("YOUR_PUBLIC_KEY") // Thay thế bằng khóa công khai của bạn
                .parseClaimsJws(token)
                .getBody();

        String roles = (String) claims.get("roles");
        return roles.contains("ROLE_ADMIN");
    }

    @Override
    public boolean isAdminUserE(String authorizationHeader) {
        String token = authorizationHeader.replace("Bearer ", "");
        Claims claims = Jwts.parser()
                .setSigningKey("YOUR_PUBLIC_KEY") // Thay thế bằng khóa công khai của bạn
                .parseClaimsJws(token)
                .getBody();

        String roles = (String) claims.get("roles");
        return roles.contains("ROLE_EMPLOYEE");
    }
}
