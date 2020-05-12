package com.epxing.demo.security.config;

import com.epxing.demo.security.handler.SSOAccessDeniedHandler;
import com.epxing.demo.security.handler.SSOAuth2WebSecurityExpressionHandler;
import com.epxing.demo.security.handler.SSOAuthenticationEntryPoint;
import com.epxing.demo.security.jwt.SSOBearerTokenExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @author chenling
 * @date 2020/5/12 22:23
 * @since V1.0.0
 */
@Configuration
@EnableResourceServer
public class SSOResourceServerConfig extends ResourceServerConfigurerAdapter {


    @Autowired
    private SSOAccessDeniedHandler accessDeniedHandler;

    @Autowired
    private SSOAuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private SSOAuth2WebSecurityExpressionHandler oAuth2WebSecurityExpressionHandler;

    @Autowired
    private SSOBearerTokenExtractor bearerTokenExtractor;

    @Autowired
    private TokenStore tokenStore;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources
                // 自定义401认证失败的错误处理
                .authenticationEntryPoint(authenticationEntryPoint)
                // 自定义403鉴权失败的错误处理
                .accessDeniedHandler(accessDeniedHandler)
                // 自定义表达式处理
                .expressionHandler(oAuth2WebSecurityExpressionHandler)
                // 自定义jwt token解析器
                .tokenExtractor(bearerTokenExtractor)
                .tokenStore(tokenStore);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.httpBasic().disable().formLogin().disable();
        http.authorizeRequests()
                .anyRequest().access("#permissionService.hasPermission(request, authentication)");

    }
}
