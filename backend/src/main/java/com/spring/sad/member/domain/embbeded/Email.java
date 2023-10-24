package com.spring.sad.member.domain.embbeded;

import com.spring.sad.member.exception.MemberErrorCode;
import com.spring.sad.member.exception.MemberException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class Email {
    private static final String EMAIL_FORMAT = "^[a-z0-9._-]+@[a-z]+[.]+[a-z]$"; //글자수제한은 추후 추가
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_FORMAT);

    @Column(unique = true, nullable = false)
    private String email;

    private Email(String email){
        this.email = email;
    }

    private static void validateEmailFormat(String email){
        if(!EMAIL_PATTERN.matcher(email).matches()) {
            throw new MemberException(MemberErrorCode.INVALID_EMAIL_FORMAT);
        }
    }

    public static Email from(String email){
        validateEmailFormat(email);
        return new Email(email);
    }
}
