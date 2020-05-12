package com.epxing.demo.enums;

/**
 * @author chenling
 * @date 2020/5/12 21:54
 * @since V1.0.0
 */

public enum ResultEnum  implements BaseEnumType{


    /**
     * token令牌不能为空
     */
    TOKEN_NOT_FOUND("200001", "token不能为空！"),
    /**
     * 企业ID不能为空
     */
    ENTERPRISE_ID_NOT_FOUND("200004", "请求ID不能为空！"),

    USERNAME_NOT_FOUND("200003", "用户名不能为空！"),

    REQUEST_ID_NOT_FOUND("200005", "requestId不能为空！"),
    /**
     * 租户ID不能为空
     */
    TENANT_ID_NOT_FOUND("200002", "tenantId不能为空！"),

        ;

    private String code;

    private String msg;

    ResultEnum(String code,String msg){
        this.code =code;
        this.msg =msg;
    }

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getMsg() {
        return null;
    }
}

