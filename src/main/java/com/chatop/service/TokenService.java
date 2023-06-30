package com.chatop.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import com.chatop.model.Users;
import com.chatop.repository.UsersRepository;
import com.nimbusds.jose.Algorithm;
import com.nimbusds.jwt.JWT;

@Service
public class TokenService {

    private final JwtEncoder encoder;
    private final JwtDecoder decoder;
    @Autowired
    private UsersRepository usersRepository;
    
    public TokenService(JwtEncoder encoder, JwtDecoder decoder) {
        this.encoder = encoder;
        this.decoder = decoder;
    }

    public String generateToken(String mail) {
        Instant now = Instant.now();
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plus(1, ChronoUnit.HOURS))
                .subject(mail)
                .build();
        return this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

		  public Users validateJwtToken(String tokenEncoded) {			  
			  String[] tokenSplited = tokenEncoded.split(" ");
			  	Jwt jwt =  decoder.decode(tokenSplited[1]);
			  return usersRepository.findByEmail(jwt.getSubject());
		  }
		

}