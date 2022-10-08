package com.chomolungma.system.account.infrastructure;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.chomolungma.common.exception.BusinessRuntimeException;
import com.chomolungma.system.account.interfaces.dto.AccountDTO;
import com.chomolungma.system.login.domain.UserDetail;

import java.util.HashMap;
import java.util.Map;

public class TokenUtils {
    public static String secret = "768594";
    public static String encode(AccountDTO account){
        String token = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            Map<String, Object> header = new HashMap<>();
            header.put("alg", "HS256");
            header.put("typ", "JWT");

            token = JWT.create()
                    .withHeader(header)
                    .withClaim("userid", account.getId())
                    .withClaim("username", account.getUsername())
                    .withClaim("roleIds", account.getRoleIds())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            exception.printStackTrace();
        }

        return token;
    }

    public static String encode(UserDetail userDetail){
        String token = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            Map<String, Object> header = new HashMap<>();
            header.put("alg", "HS256");
            header.put("typ", "JWT");

            token = JWT.create()
                    .withHeader(header)
                    .withClaim("userid", userDetail.getAccount().getId())
                    .withClaim("username", userDetail.getAccount().getUsername())
                    .withClaim("roleIds", userDetail.getAccount().getRoles())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            exception.printStackTrace();
        }

        return token;
    }

    public static AccountDTO decode(String token){
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).build();
        DecodedJWT jwt = null;
        AccountDTO account = new AccountDTO();
        try {
            jwt = verifier.verify(token);
            account.setId(jwt.getClaim("userid").asLong());
            account.setUsername(jwt.getClaim("username").asString());
            account.setRoleIds(jwt.getClaim("roleIds").asList(Long.class));
        }catch (Exception e){
            throw new BusinessRuntimeException("凭证已过期，请重新登录");
        }
        return account;
    }
}
