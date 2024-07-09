package camellia.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.Map;

public class JwtUtils {

    // 签名密钥，用于对JWT进行签名和验证签名
    private static String signKey = "camellia";
    // 令牌过期时间，单位为毫秒，这里设置为12小时（43200000毫秒）
    private static Long expire = 43200000L;

    /**
     * 生成JWT令牌
     *
     * @param claims JWT第二部分负载（payload）中存储的内容，通常是一个包含用户信息的Map
     * @return 生成的JWT字符串
     */
    public static String generateJwt(Map<String, Object> claims) {
        // 使用Jwts.builder()创建JWT构建器
        String jwt = Jwts.builder()
                // 将传入的Map对象添加到JWT的声明中
                .addClaims(claims)
                // 使用HS256算法和指定的签名密钥对JWT进行签名
                .signWith(SignatureAlgorithm.HS256, signKey)
                // 设置JWT的过期时间为当前时间加上指定的过期时长
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                // 压缩JWT以生成最终的紧凑的JWT字符串
                .compact();
        // 返回生成的JWT字符串
        return jwt;
    }

    /**
     * 解析JWT令牌
     *
     * @param jwt JWT令牌字符串
     * @return JWT第二部分负载（payload）中存储的内容，通常是一个包含用户信息的Claims对象
     */
    public static Claims parseJWT(String jwt) {
        // 使用Jwts.parser()创建JWT解析器
        Claims claims = Jwts.parser()
                // 设置签名密钥，用于验证JWT的签名
                .setSigningKey(signKey)
                // 解析JWT字符串并获取其负载部分（payload）
                .parseClaimsJws(jwt)
                // 获取JWT的负载部分（payload）
                .getBody();
        // 返回负载部分（payload）
        return claims;
    }
}
