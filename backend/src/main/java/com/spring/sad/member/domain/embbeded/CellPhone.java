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
public class CellPhone {
    private static final String CELL_PHONE_NUMBER_FORMAT = "^010\\d{8}$\n";

    private static final Pattern CELL_PHONE_NUMBER_PATTERN = Pattern.compile(CELL_PHONE_NUMBER_FORMAT);

    @Column(name = "cell_phone")
    private String value;

    private CellPhone(String cellPhone) {
        value = cellPhone;
    }

    public static CellPhone from(String cellPhone) {
        validationCellPhoneFormat(cellPhone);
        return new CellPhone(cellPhone);
    }

    private static void validationCellPhoneFormat(String cellPhone) {
        if (!CELL_PHONE_NUMBER_PATTERN.matcher(cellPhone).matches()) {
            throw new MemberException(MemberErrorCode.CELL_PHONE_IS_NOT_VALID);
        }
    }
}
