package br.com.vehicle.qualitymanagement.security;

import br.com.vehicle.qualitymanagement.infra.jpa.entity.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class TokenService {

    @Value("${jwt.expiration}")
    private String expiration;

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(Authentication authentication) {
        UserEntity loggedUser = (UserEntity) authentication.getPrincipal();
        String userIdentification = loggedUser.getId().toString();
        Date today = new Date();
        Date expirationTime = new Date(today.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
                .setIssuer("api-school-backend") //who is generating this token
                .setSubject(userIdentification) //string that identify user
                .setIssuedAt(today) //token generation data
                .setExpiration(expirationTime) //token expiration data
                .signWith(SignatureAlgorithm.HS256, secret) //secret key to encrypt token
                .compact();

    }

    public boolean isValid(String token) {
        try {
            Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public UUID getUserId(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret)
            .parseClaimsJws(token).getBody();

        return UUID.fromString(claims.getSubject());
    }
}
