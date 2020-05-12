package com.epxing.demo.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chenling
 * @date 2020/5/13 1:10
 * @since V1.0.0
 */
@Slf4j
@Service
public class PermissionServiceImpl implements  PermissionService {


    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        log.info("----------------自定义权限信息-------------");

        return true;
    }
}
