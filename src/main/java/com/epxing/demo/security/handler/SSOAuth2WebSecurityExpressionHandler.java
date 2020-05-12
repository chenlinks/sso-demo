package com.epxing.demo.security.handler;

import com.epxing.demo.security.PermissionService;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

/**
 * @author chenling
 * @date 2020/5/12 22:33
 * @since V1.0.0
 */
@Component
public class SSOAuth2WebSecurityExpressionHandler extends OAuth2WebSecurityExpressionHandler {

    private PermissionService permissionService;

    public SSOAuth2WebSecurityExpressionHandler(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @Override
    protected StandardEvaluationContext createEvaluationContextInternal(Authentication authentication,
                                                                        FilterInvocation invocation) {
        StandardEvaluationContext sec = super.createEvaluationContextInternal(authentication, invocation);
        sec.setVariable("permissionService", permissionService);
        return sec;
    }

}
