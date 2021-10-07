package com.wen.server.config.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * jwtToken工具类
 */
@Component
public class JwtTokenUtils {

    //荷载的主体的key
    private static final String CLAIM_KEY_USERNAME = "sub";
    //荷载的签发时间的key
    private static final String CLAIM_KEY_CREATED = "created";

    //签名
    @Value("${jwt.secret}")
    private String secret;

    //过期时间
    @Value("${jwt.expiration}")
    private Long expiration;

    /**
     * 根据用户信息,生成token
     *
     * @param userDetails 用户信息
     * @return 根据用户信息生成token
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    /**
     * 从token中获取登录用户名
     *
     * @param token 生成的token
     * @return 从token中的荷载得到的用户名
     */
    public String getUserNameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
     * 从token获取荷载
     *
     * @param token 生成的token
     * @return token中的荷载
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claims;
    }

    /**
     * 验证token是否有效
     *
     * @param token       生成的token
     * @param userDetails 用户信息
     * @return 当token中的用户名和用户信息中的用户名不一致或者token已经过期的话, 返回false
     * 同时满足,返回true
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = getUserNameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    /**
     * 判断token是否可以被刷新
     *
     * @param token 生成的token
     * @return token过期可以刷新, 返回true, token没过期, 返回false
     */
    public boolean canRefresh(String token) {
        return !isTokenExpired(token);
    }

    /**
     * 刷新token
     *
     * @param token 生成的原始token
     * @return 刷新之后新的token
     */
    public String refreshToken(String token) {
        Claims claims = getClaimsFromToken(token);
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }


    /**
     * 判断token是否已经过期
     *
     * @param token 生成的token
     * @return token的过期时间在当前时间前, 返回true,代表已经过期, 否则返回false,代表还没过期
     */
    private boolean isTokenExpired(String token) {
        Date expiredDate = getExpiredDateFromToken(token);
        return expiredDate.before(new Date());
    }

    /**
     * 从token中获取过期时间
     *
     * @param token 生成的token
     * @return token中的过期时间
     */
    private Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }

    /**
     * 根据荷载,生成JWT Token
     *
     * @param claims 荷载主体
     * @return 根据荷载主体生成JWT Token
     */
    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 生成token失效时间
     *
     * @return Token失效的时间
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

}
