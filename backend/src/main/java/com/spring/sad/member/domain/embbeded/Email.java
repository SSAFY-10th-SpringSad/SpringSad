package com.spring.sad.member.domain.embbeded;

import com.spring.sad.member.exception.MemberErrorCode;
import com.spring.sad.member.exception.MemberException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
@Getter
public class Email {
    private static final String EMAIL_FORMAT = "^[a-z0-9._-]{5,16}+@[a-z]+[.]+[a-z]{2,3}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_FORMAT);

    @Column(name = "email")
    private String value;

    private Email(String email) {
        value = email;
    }

    public static Email from(String email) {
        validationEmailFormat(email);
        return new Email(email);
    }

    private static void validationEmailFormat(String email) {
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new MemberException(MemberErrorCode.EMAIL_IS_NOT_VALID);
        }
    }
}
