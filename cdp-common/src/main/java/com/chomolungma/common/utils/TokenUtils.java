package com.chomolungma.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.chomolungma.core.exception.BusinessRuntimeException;

import java.util.HashMap;
import java.util.Map;

public class TokenUtils {
    public static String secret = "768594";
//    public static String encode(UserDetail account){
//        String token = null;
//        try {
//            Algorithm algorithm = Algorithm.HMAC256(secret);
//
//            Map<String, Object> header = new HashMap<>();
//            header.put("alg", "HS256");
//            header.put("typ", "JWT");
//
//            token = JWT.create()
//                    .withHeader(header)
//                    .withClaim("userid", account.getAccountId())
//                    .withClaim("username", account.getUsername())
//                    .withClaim("roleIds", account.getRoleIds())
//                    .sign(algorithm);
//        } catch (JWTCreationException exception){
//            exception.printStackTrace();
//        }
//
//        return token;
//    }

    public static String encode(Long accountId){
        String token = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            Map<String, Object> header = new HashMap<>();
            header.put("alg", "HS256");
            header.put("typ", "JWT");

            token = JWT.create()
                    .withHeader(header)
                    .withClaim("userid", accountId)
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            exception.printStackTrace();
        }

        return token;
    }

//    public static AccountDTO decodeOld(String token){
//        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).build();
//        DecodedJWT jwt = null;
//        AccountDTO account = new AccountDTO();
//        try {
//            jwt = verifier.verify(token);
//            account.setId(jwt.getClaim("userid").asLong());
//            account.setUsername(jwt.getClaim("username").asString());
//            account.setRoleIds(jwt.getClaim("roleIds").asList(Long.class));
//        }catch (Exception e){
//            throw new BusinessRuntimeException("凭证已过期，请重新登录");
//        }
//        return account;
//    }

    public static Long decode(String token){
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).build();
        Long accountId;
        try {
            accountId = verifier.verify(token).getClaim("userid").asLong();

        }catch (Exception e){
            throw new BusinessRuntimeException("凭证已过期，请重新登录");
        }
        return accountId;
    }
}
