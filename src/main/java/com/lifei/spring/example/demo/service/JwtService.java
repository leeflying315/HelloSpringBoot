package com.lifei.spring.example.demo.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author lifei
 * @Description:
 * @Date 2021/6/9
 */
@Service
@Slf4j
public class JwtService {
    public String createToken(String accessKey, String accessSecret) throws Exception {
        return getToken(accessKey,accessSecret);
    }

    public void verifyToken(String token, String key) throws Exception {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(key))
                .build();
        DecodedJWT jwt = verifier.verify(token);
        Map<String, Claim> claims = jwt.getClaims();
        log.info("{}", claims);
    }

    public String getToken(String accessKey, String accessSecret) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("alg","HS256");
        map.put("typ","JWT");
        Long currentTimestamp = System.currentTimeMillis();
        Long expirationTimestamp = currentTimestamp+1800000;
        String token = JWT.create().withHeader(map)
                .withClaim("iss",accessKey)
                .withClaim("iat",new Date(currentTimestamp))
                .withClaim("exp",new Date(expirationTimestamp))
                .sign(Algorithm.HMAC256(accessSecret));

        return token;
    }
}
