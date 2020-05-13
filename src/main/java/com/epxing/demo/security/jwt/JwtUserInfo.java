package com.epxing.demo.security.jwt;

import lombok.Data;

/**
 * jwt 中存储的用户信息
 *
 */
@Data
public class JwtUserInfo {
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 租户ID
     */
    private String tenantId;
    /**
     * 企业ID
     */
    private String enterpriseCode;

    private String account;

    private String accountId;
}
