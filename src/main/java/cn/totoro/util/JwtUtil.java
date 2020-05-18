package cn.totoro.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.io.IOException;
import java.security.Key;
import java.util.Date;

public class JwtUtil {

    private static final String SECURITY_KEY = "GoEKUFX1evj0G6igJyPlYWaErgmNvsSPyaTeCcmqNgWeraCJauv3KdxMCAYv1u9vscc8yE+";


    public static <T> String sign(T object) {
        /**
         * 加密思路：
         * 1.设置KEY
         * 2.设置使用时间
         * 3.生成密钥
         * 4.返回密钥
         */
        Key key = Keys.hmacShaKeyFor(SECURITY_KEY.getBytes());
        ObjectMapper mapper = new ObjectMapper();
        String token = null;
        try {
            token = Jwts.builder()
                    .setSubject(mapper.writeValueAsString(object))
                    .signWith(key)
                    .setExpiration(new Date(System.currentTimeMillis()+3600000))
                    .compact();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return token;
    }


    public static <T> T verify(String token,Class<T> tClass) {
        Key key = Keys.hmacShaKeyFor(SECURITY_KEY.getBytes());
        ObjectMapper mapper = new ObjectMapper();
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                        .getBody();
        try {
            return mapper.readValue(claims.getSubject(),tClass);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }



}
