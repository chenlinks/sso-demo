package com.epxing.demo.security.jwt;

/**
 * desc: JWT常量
 */
public interface JwtConstants {

    /**
     * JWT私钥
     */
    String JWT_SECRET = "d20a0382a5f840f7afbd3f4df92ecaf8";

    /**
     * jwt2.0版本token记录accountId
     */
    String JWT2_TOKEN_ACCOUNT_ID = "accountId";

    /**
     * jwt2.0版本token记录tokenId
     */
    String JWT2_TOKEN_TENANT_ID = "tenantId";


    /**
     * jwt3.0版本token记录userInfo
     */
    String JWT3_TOKEN_USER_INFO = "userInfo";
}
