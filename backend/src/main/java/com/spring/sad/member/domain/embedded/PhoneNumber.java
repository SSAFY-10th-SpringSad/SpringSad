package com.spring.sad.member.domain.embedded;

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
public class PhoneNumber {
    private static final String PHONE_NUMBER_FORMAT = "^\\d{3}-?\\d{3,4}-?\\d{4}$";
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile(PHONE_NUMBER_FORMAT);

    @Column(name = "phone_number", unique = true)
    private String value;

    private PhoneNumber(String phoneNumber) {
        value = phoneNumber;
    }

    public static PhoneNumber from(String phoneNumber) {
        validatePhoneNumberFormat(phoneNumber);
        return new PhoneNumber(phoneNumber);
    }

    private static void validatePhoneNumberFormat(String phoneNumber) {
        if(!PHONE_NUMBER_PATTERN.matcher(phoneNumber).matches()) {
            throw new MemberException(MemberErrorCode.INVALID_PHONE_NUMBER_FORMAT);
        }
    }
}
