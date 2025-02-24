package com.nageoffer.shortlink.admin.common.enums;

import com.nageoffer.shortlink.admin.common.convention.errorcode.IErrorCode;

public enum UserErrorCode implements IErrorCode {

    USER_TOKEN_FAIL("A0002000", "用户token验证失败"),
    USER_NULL("B0002000", "用户不存在"),
    USER_NAME_EXIST("B0002001", "用户名已存在"),
    USER_EXIST("B0002002", "用户已存在"),
    USER_SAVE_ERROR("B0002003", "用户新增失败");

    private final String code;

    private final String message;

    UserErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }

}