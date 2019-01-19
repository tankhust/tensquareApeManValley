package com.tensquare.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.text.SimpleDateFormat;

/**
 * @author tank
 * @create 2019/01/19 13:26
 */
public class ParseJwtTest {
    public static void main(String[] args) {
        String token="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiLlsI_pqawiLCJpYXQiOjE1NDc4NzYxMjIsImV4cCI6MTU0Nzg3NjE4Miwicm9sZXMiOiJhZG1pbiJ9.Y_CY4Be5ZhSyzpow_TpYatyAF1Y0vAU7T7vFdvxeLiw";
        Claims claims =
                Jwts.parser().setSigningKey("itcast").parseClaimsJws(token).getBody();
        System.out.println("id:"+claims.getId());
        System.out.println("subject:"+claims.getSubject());
        System.out.println("签发时间:"+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(claims.getIssuedAt()));
        System.out.println("过期时间:"+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(claims.getExpiration()));
        System.out.println("roles:"+claims.get("roles"));

    }
}
