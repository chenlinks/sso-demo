package com.epxing.demo.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.exceptions.BadClientCredentialsException;
import org.springframework.security.oauth2.provider.authentication.BearerTokenExtractor;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author chenling
 * @date 2020/5/12 22:36
 * @since V1.0.0
 */
@Slf4j
@Component
public class SSOBearerTokenExtractor extends BearerTokenExtractor {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;


    @Override
    public Authentication extract(HttpServletRequest request) {
        String tokenValue = extractToken(request);
        if (tokenValue != null) {
            // 解析jwt token中的内容
            JwtUserInfo jwtUserInfo = new JwtUserInfo();
            try {
                String jwtKey = jwtAccessTokenConverter.getKey().get("value");
                Claims claims = Jwts.parser().setSigningKey(jwtKey.getBytes(StandardCharsets.UTF_8)).parseClaimsJws(tokenValue).getBody();
                String userStr = objectMapper.writeValueAsString(claims.get(JwtConstants.JWT3_TOKEN_USER_INFO));
                jwtUserInfo = objectMapper.readValue(userStr, JwtUserInfo.class);
                log.info("jwtUserInfo:{}", jwtUserInfo);
            } catch(Exception e) {
                log.error("token验证错误", e);
                throw new BadClientCredentialsException();
            }

            PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken(tokenValue, "");
            return authentication;
        }else{
            log.error("token is null");
        }
        return null;
    }
}
