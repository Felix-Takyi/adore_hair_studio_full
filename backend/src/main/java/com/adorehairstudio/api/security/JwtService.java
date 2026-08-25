package com.adorehairstudio.api.security;
import io.jsonwebtoken.*; import io.jsonwebtoken.security.Keys; import org.springframework.beans.factory.annotation.Value; import org.springframework.stereotype.Service; import javax.crypto.SecretKey; import java.nio.charset.StandardCharsets; import java.time.*; import java.time.temporal.ChronoUnit; import java.util.Date;
@Service
public class JwtService {
 private final SecretKey key; private final long expirationMinutes;
 public JwtService(@Value("${app.jwt.secret}") String secret,@Value("${app.jwt.expiration-minutes}") long expirationMinutes){ this.key=Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8)); this.expirationMinutes=expirationMinutes; }
 public String create(String email){ Instant now=Instant.now(); return Jwts.builder().subject(email).issuedAt(Date.from(now)).expiration(Date.from(now.plus(expirationMinutes,ChronoUnit.MINUTES))).signWith(key).compact(); }
 public String subject(String token){ try{return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().getSubject();}catch(Exception e){return null;} }
}
