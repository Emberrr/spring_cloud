package com.cjzf.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cjzf.entity.User;
import com.cjzf.web.vo.security.Audience;
import com.cjzf.web.vo.security.LoginParameter;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * @ClassName JwtUtils
 * @Description
 * @author nicholas
 * @Date 2018年1月11日 上午12:21:34
 * @version 1.0.1
 */
@Slf4j
public class JwtUtils {
    private static final Logger log = LoggerFactory.getLogger(JwtUtils.class);
    
    private JwtUtils() {
    }

    /**
     * 验证jwt是否合法
     *
     * @param jsonWebToken
     * @param base64Security
     * @return
     */
    public static Claims parseJWT(String jsonWebToken, String base64Security) {
        try {
            return Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
                    .parseClaimsJws(jsonWebToken).getBody();
        } catch (Exception e) {
            log.error("exception message is: {}", ExceptionUtils.getStackTrace(e));
            return null;
        }
    }

    /**
     * 创建JWT
     *
     * @param loginParameter
     * @param user
     * @param audience
     * @return
     */
    public static String createJWT(LoginParameter loginParameter, User user, Audience audience) {
        long ttlmillis = audience.getExpiresSecond() * 1000L;
        String base64Security = audience.getBase64Secret();
        Date now = new Date(System.currentTimeMillis());

        //生成签名密钥
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Security);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());

        //添加构成JWT的参数
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
                .claim("role", user.getRole())
                .claim("unique_name", loginParameter.getUserName())
                .claim("userid", user.getUserName())
                .setIssuer(audience.getName())
                .setAudience(audience.getClientId())
                .signWith(SignatureAlgorithm.HS256, signingKey);

        //添加Token过期时间
        if (ttlmillis >= 0) {
            Date exp = new Date(System.currentTimeMillis() + ttlmillis);
            builder.setExpiration(exp).setNotBefore(now);
        }

        //生成JWT
        return builder.compact();
    }
}