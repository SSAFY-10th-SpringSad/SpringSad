package com.spring.sad.member.exception;

import com.spring.sad.global.exception.ErrorCode;
import com.spring.sad.global.exception.SadException;

public class MemberException extends SadException {
    public MemberException(ErrorCode errorCode) {
        super(errorCode);
    }
}
