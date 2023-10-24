package com.spring.sad.member.domain.embbeded;

import com.spring.sad.member.exception.MemberErrorCode;
import com.spring.sad.member.exception.MemberException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.regex.Pattern;

@Embeddable
public class CellPhone {
    private static final String CELL_PHONE_FORMAT = "^\\d{3}-?\\d{3,4}-?\\d{4}$";
    private static final Pattern CELL_PHONE_PATTERN = Pattern.compile(CELL_PHONE_FORMAT);

    @Column(unique = true, nullable = false)
    private String cellPhone;

    private CellPhone(String cellPhone){
        this.cellPhone = cellPhone;
    }

    private static void validateCellPhoneFormat(String cellPhone){
        if(!CELL_PHONE_PATTERN.matcher(cellPhone).matches()){
            throw new MemberException(MemberErrorCode.INVALID_CELL_PHONE_FORMAT);
        }
    }

    public static CellPhone from(String cellPhone){
        validateCellPhoneFormat(cellPhone);
        return new CellPhone(cellPhone);
    }

}
