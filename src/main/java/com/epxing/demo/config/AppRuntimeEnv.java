package com.epxing.demo.config;

import com.epxing.demo.enums.ResultEnum;
import com.epxing.demo.exception.ApplicationException;
import org.springframework.stereotype.Component;

/**
 * @author chenling
 * @date 2020/5/12 21:53
 * @since V1.0.0
 */
@Component
public class AppRuntimeEnv {

    /**
     * 租户编码
     */
    private ThreadLocal<String> tenantId = ThreadLocal.withInitial(() -> null);

    /**
     * 企业ID
     */
    private ThreadLocal<String> enterpriseCode = ThreadLocal.withInitial(() -> null);

    /**
     * token信息
     */
    private ThreadLocal<String> token = ThreadLocal.withInitial(() -> null);
    /**
     * userId信息
     */
    private ThreadLocal<Long> userId = ThreadLocal.withInitial(() -> null);
    /**
     * 用户名
     */
    private ThreadLocal<String> username = ThreadLocal.withInitial(() -> "ANONYMOUS");

    /**
     * requestId 请求ID
     */
    private ThreadLocal<String> requestId = ThreadLocal.withInitial(() -> null);


    public AppRuntimeEnv ensureToken(String token) {
        if (null == token) {
            throw new ApplicationException(ResultEnum.TOKEN_NOT_FOUND);
        }
        this.token.set(token);
        return this;
    }

    public AppRuntimeEnv ensureTenantId(String tenantId) {
        if (null == tenantId) {
            throw new ApplicationException(ResultEnum.TENANT_ID_NOT_FOUND);
        }
        this.tenantId.set(tenantId);
        return this;
    }

    public AppRuntimeEnv ensureEnterpriseCode(String enterpriseCode) {
        if (null == enterpriseCode) {
            throw new ApplicationException(ResultEnum.ENTERPRISE_ID_NOT_FOUND);
        }
        this.enterpriseCode.set(enterpriseCode);
        return this;
    }

    public AppRuntimeEnv ensureUsername(String username) {
        if (null == username) {
            throw new ApplicationException(ResultEnum.USERNAME_NOT_FOUND);
        }
        this.username.set(username);
        return this;
    }

    public AppRuntimeEnv ensureRequestId(String requestId) {
        if (null == requestId) {
            throw new ApplicationException(ResultEnum.REQUEST_ID_NOT_FOUND);
        }
        this.requestId.set(requestId);
        return this;
    }

    public void setTenantId(String tenantId) {
        this.tenantId.set(tenantId);
    }

    public void setToken(String token) {
        this.token.set(token);
    }

    public String getTenantId() {
        return tenantId.get();
    }

    public String getToken() {
        return token.get();
    }

    public void setUserId(Long userId) {
        this.userId.set(userId);
    }

    public Long getUserId() {
        return userId.get();
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getUsername() {
        return username.get();
    }

    public void setRequestId(String requestId) {
        this.requestId.set(requestId);
    }

    public String getRequestId() {
        return requestId.get();
    }

    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode.set(enterpriseCode);
    }

    public String getEnterpriseCode() {
        return enterpriseCode.get();
    }

    /**
     * 清空上下文信息
     */
    public void clearContext() {
        this.setEnterpriseCode(null);
        this.setRequestId(null);
        this.setTenantId(null);
        this.setToken(null);
        this.setUserId(null);
        this.setUsername(null);
    }
}
