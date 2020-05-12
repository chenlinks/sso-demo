package com.epxing.demo.security.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.http.AccessTokenRequiredException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author chenling
 * @date 2020/5/12 22:31
 * @since V1.0.0
 */
@Slf4j
@Component
public class SSOAuthenticationEntryPoint extends OAuth2AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        if(authException instanceof AccessTokenRequiredException) {
            // 没有携带令牌
            log.info("2. udpate log to 401");
        }else {
            // 携带了错误的令牌
            log.info("2. add log 401");
        }

        request.setAttribute("logUpdated", "yes");

        super.commence(request, response, authException);
    }

}
