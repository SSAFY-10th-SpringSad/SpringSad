package com.spring.sad.member.exception;

import com.spring.sad.global.exception.ErrorCode;
import com.spring.sad.global.exception.GlobalException;

public class MemberException extends GlobalException {
    public MemberException(ErrorCode code){
        super(code);
    }
}
