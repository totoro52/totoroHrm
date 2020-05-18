package cn.totoro.util;

import cn.totoro.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.jsonwebtoken.security.SignatureException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;

import static org.junit.Assert.*;

public class JwtUtilTest {



    @Test
    public void sign() throws JsonProcessingException {
        User user = new User();
        user.setId(1);
        user.setPassword("2123");
        user.setCreateDate(new Date());
        user.setLoginName("123");
        user.setStatus(1);
        String token = JwtUtil.sign(user);
        System.out.println(token);
    }

    @Test
    public void verify() throws IOException {
        String token  = "eyJhbGciOiJIUzUxMiJ9.eJzdWIiOiJ7XCJpZFwiOjEsXCJsb2dpbk5hbWVcIjpcIjEyM1wiLFwicGFzc3dvcmRcIjpcIjIxMjNcIixcInN0YXR1c1wiOjEsXCJjcmVhdGVEYXRlXCI6MTU4ODM5Mjc0Mzc2NixcInVzZXJOYW1lXCI6bnVsbH0iLCJleHAiOjE1ODgzOTYzNDR9.qkqQ-9bSNvmzrDVY6SKUyCthtV8jxfDDRpCl1AGFjB4iLuKVqXYe_q4yW6JxJYxsz6udshH_k-1Sj9yJfqzpjg";
        User user = JwtUtil.verify(token,User.class);
        System.out.println(user);
    }
}