package com.yalla.yalla_backend.security;

import com.yalla.yalla_backend.models.User;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

//This Util Class is what generates, manages, and validates our JWTs -- thanks to Ben Petruzziello for the utility class
//JWT (JSON Web Token) is a stateless security token
//We will set up our app so that the user cannot do anything besides login/register w/o  a valid JWT
@Component
public class JwtTokenUtil {
    //this is how long the token lasts
    private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000; // 24 hour life for our JWT, so the cookie goes poof later

    //this is the secret key for encrypting the token, pulled from application.properties
    @Value("${app.jwt.secret}") //taken out of application.properties
    private String SECRET_KEY;

    //this logs warnings and errors
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);

    //verify a given JWT. It returns true if the JWT is verified, or false otherwise.
    public boolean validateAccessToken(String token) {
        LOGGER.info("Inside validateAccessToken");
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException ex) {
            LOGGER.error("JWT expired", ex.getMessage());
        } catch (IllegalArgumentException ex) {
            LOGGER.error("Token is null, empty or only whitespace", ex.getMessage());
        } catch (MalformedJwtException ex) {
            LOGGER.error("JWT is invalid", ex);
        } catch (UnsupportedJwtException ex) {
            LOGGER.error("JWT is not supported", ex);
        } catch (SignatureException ex) {
            LOGGER.error("Signature validation failed");
        }

        return false;
    }

    //This method creates our JWT! The user's unique identifier token
    //This gets called after successful login
    public String generateAccessToken(User u) {
        return Jwts.builder()
                .setSubject(String.format("%s", u.getUserId())) //subject is typically ID
                .claim("username", u.getUsername()) //any other data that isnt the id is a claim
                .claim("role", u.getRole())
                .setIssuer("Yalla") //who issued the tokena
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    //The below 3 methods are like getters for your JWT - they'll extract info out of them

    //we need this method to get the userID from the JWT (stored in the subject)
    //the subject tends to be used for unique identifiers
    public UUID extractUserId(String token) {
        Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token);
        String subject = claimsJws.getBody().getSubject();
        return UUID.fromString(subject);
    }

    //we need the following 2 methods to get the username and role from the JWT (stored in the claims)
    //claims tend to be used for other non-id information about the user. email, full name, etc.
    public String extractUsername(String token) {
        Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token);
        return claimsJws.getBody().get("username", String.class);
    }

    public String extractRole(String token) {
        Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token);
        return claimsJws.getBody().get("role", String.class);
    }

    //TODO: Write more methods for grabbing anything else we need out of the JWT

}