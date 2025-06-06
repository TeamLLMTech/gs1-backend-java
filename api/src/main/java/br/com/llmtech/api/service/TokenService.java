package br.com.llmtech.api.service;

import br.com.llmtech.api.exception.ForbiddenException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(String username) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("llmtech")
                    .withSubject(username)
                    .withExpiresAt(genExpirationInstant())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro na geração de token", exception);
        }
    }

    private Instant genExpirationInstant() {
        return LocalDateTime
                .now()
                .plusMinutes(60)
                .toInstant(ZoneOffset.of("-03:00"));
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("llmtech")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (Exception exception) {
            throw new ForbiddenException("Acesso negado", exception);
        }
    }
}
