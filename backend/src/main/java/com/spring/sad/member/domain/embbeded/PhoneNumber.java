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
public class PhoneNumber {
    private static final String PHONE_NUMBER_NUMBER_FORMAT = "^010\\d{8}$";

    private static final Pattern PHONE_NUMBER_NUMBER_PATTERN = Pattern.compile(PHONE_NUMBER_NUMBER_FORMAT);

    @Column(name = "phone_number")
    private String value;

    private PhoneNumber(String phoneNumber) {
        value = phoneNumber;
    }

    public static PhoneNumber from(String phoneNumber) {
        validationCellPhoneFormat(phoneNumber);
        return new PhoneNumber(phoneNumber);
    }

    private static void validationCellPhoneFormat(String phoneNumber) {
        if (!PHONE_NUMBER_NUMBER_PATTERN.matcher(phoneNumber).matches()) {
            throw new MemberException(MemberErrorCode.PHONE_NUMBER_IS_NOT_VALID);
        }
    }
}
