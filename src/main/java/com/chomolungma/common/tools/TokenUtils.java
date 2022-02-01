package com.chomolungma.common.tools;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.chomolungma.account.entity.AccountEntity;
import com.chomolungma.common.exception.BusinessRuntimeException;

import java.util.HashMap;
import java.util.Map;

public class TokenUtils {
    public static String secret = "768594";
    public static String encode(AccountEntity accountEntity){
        String token = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            Map<String, Object> header = new HashMap<>();
            header.put("alg", "HS256");
            header.put("typ", "JWT");

            token = JWT.create()
                    .withHeader(header)
                    .withClaim("userid", accountEntity.getId())
                    .withClaim("username", accountEntity.getUsername())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            exception.printStackTrace();
        }

        return token;
    }

    public static AccountEntity decode(String token){
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).build();
        DecodedJWT jwt = null;
        AccountEntity accountEntity = new AccountEntity();
        try {
            jwt = verifier.verify(token);
            accountEntity.setId(jwt.getClaim("userid").asLong());
            accountEntity.setUsername(jwt.getClaim("username").asString());
        }catch (Exception e){
            throw new RuntimeException("凭证已过期，请重新登录");
        }
        return accountEntity;
    }
}
