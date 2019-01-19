package com.tensquare.jwt;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author tank
 * @create 2019/01/18 20:00
 */
public class CreateJwtTest {
    public static void main(String[] args) {
        JwtBuilder jwtBuilder= Jwts.builder()
                .setId("666")
                .setSubject("小马")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"itcast")
                .setExpiration(new Date(new Date().getTime()+60000))//过期时间1分钟
                .claim("roles","admin");
        System.out.println( jwtBuilder.compact() );
    }
}
