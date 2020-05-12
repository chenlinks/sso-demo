package com.epxing.demo.security;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chenling
 * @date 2020/5/12 22:20
 * @since V1.0.0
 */
public interface PermissionService {


    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
