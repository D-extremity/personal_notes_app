package com.example.personal_notes_app.Services;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
public class JWTService {

    private SecretKey secretKey;

    public JWTService() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
        this.secretKey = keyGenerator.generateKey();
    }

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder().claims().add(claims).subject(username).issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 10 * 60 * 60 * 1000))
                .and().signWith(secretKey).compact();
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload();
    }

    private <T> T extractClaim(String token, Function<Claims,T> claimSupplierFunction){
        Claims claim=extractAllClaims(token);
        return claimSupplierFunction.apply(claim);
    }

    public String extractUsername(String token){
        return extractClaim(token,Claims::getSubject);
    }

    private Date extractExpirationDate(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token){
        return extractExpirationDate(token).after(new Date(System.currentTimeMillis()));
    }

    public boolean validateToken(String token, UserDetails userDetails){
        final String username=extractUsername(token);
        return (username.equals(userDetails.getUsername())) && isTokenExpired(token);
    }
}
