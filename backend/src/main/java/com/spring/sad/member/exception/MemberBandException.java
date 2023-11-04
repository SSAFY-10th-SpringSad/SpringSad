package com.spring.sad.member.exception;

import com.spring.sad.global.exception.ErrorCode;
import com.spring.sad.global.exception.GlobalException;

public class MemberBandException extends GlobalException {
    public MemberBandException(ErrorCode errorCode) {
        super(errorCode);
    }
}
