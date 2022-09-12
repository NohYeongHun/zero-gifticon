package com.zerogift.backend.common.exception;

import com.zerogift.backend.common.exception.code.OAuthErrorCode;
import lombok.Getter;

@Getter
public class OAuthException extends RuntimeException {

    private final OAuthErrorCode errorCode;
    private final String errorMessage;

    public OAuthException(OAuthErrorCode errorCode) {
        super(errorCode.getDescription());
        this.errorCode = errorCode;
        this.errorMessage = errorCode.getDescription();
    }
}