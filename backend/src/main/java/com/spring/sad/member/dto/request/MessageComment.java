package com.spring.sad.member.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MessageComment {
    static final String NEED_EMAIL = "이메일은 필수 입력 값 입니다.";
    static final String NEED_PHONE_NUMBER = "전화 번호는 필수 입력 값 입니다.";
    static final String NEED_PASSWORD = "비밀 번호는 필수 입력 값 입니다.";
    static final String PASSWORD_REGEXP = "(?=,*[0-9])(?=.*[a-zA-Z])(?=.*\\\\W)(?=\\\\S+$).{8,16}";
    static final String PASSWORD_PATTERN = "비밀 번호는 8~16자 영문 대, 소문자, 숫자, 특수 문자를 사용해주세요.";
}
