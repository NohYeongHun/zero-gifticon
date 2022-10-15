package com.zerogift.global.error.exception;

import com.zerogift.global.error.code.PayErrorCode;

public class PayRedissonClientException extends RuntimeException{
    private final PayErrorCode errorCode;
    private final String errorMessage;

    public PayRedissonClientException(PayErrorCode errorCode) {
        super(errorCode.getDescription());
        this.errorCode = errorCode;
        this.errorMessage = errorCode.getDescription();
    }
}
