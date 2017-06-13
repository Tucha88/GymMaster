package com.telra.belarus.gym.utils;

import com.telra.belarus.gym.models.Client;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Boris on 11.06.2017.
 */
@Service

public class Utils implements IUtils {
    private static int tokenExpirationTime = 7200; //5 days

    @Override
    public String getToken(String email,String id) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, tokenExpirationTime);
        return Jwts.builder()
                .setSubject(email)
                .claim("roles", "user")
                .setId(id)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "hello_world_this_is_The_secrete_12w23e2w")
                .setExpiration(calendar.getTime())
                .compact();
    }

    @Override
    public boolean isLoginInfoExist(Object obj) {
        Client client = (Client) obj;
        if (client.getClientEmail() == null || client.getClientPassword() == null ||client.getClientEmail().equals("") || client.getClientPassword().equals("")) {
            return true;
        }
        return false;
    }

    @Override
    public String hashPassword(String rawPassword) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(rawPassword);
    }

    @Override
    public String parsJwts(String token) {
        String email = Jwts.parser()
                .setSigningKey("hello_world_this_is_The_secrete_12w23e2w")
                .parseClaimsJws(token)
                .getBody()
                .get("sub", String.class);
        return email;
    }

    @Override
    public Boolean isPasswordCorrect(String newPassword, String hashedPassrod) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(newPassword, hashedPassrod);
    }
}
