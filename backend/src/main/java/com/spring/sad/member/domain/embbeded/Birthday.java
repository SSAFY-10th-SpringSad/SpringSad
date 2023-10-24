package com.spring.sad.member.domain.embbeded;

import com.spring.sad.member.exception.MemberErrorCode;
import com.spring.sad.member.exception.MemberException;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Birthday {
    private static final String YEAR_FORMAT = "^(19[0-9][0-9]|20\\d{2})$";
    private static final String MONTH_FORMAT = "^(0[0-9]|1[0-2])$";
    private static final String DAY_FORMAT = "^(0[1-9]|[1-2][0-9]|3[0-1])$";

    private static final Pattern YEAR_PATTERN = Pattern.compile(YEAR_FORMAT);
    private static final Pattern MONTH_PATTERN = Pattern.compile(MONTH_FORMAT);
    private static final Pattern DAY_PATTERN = Pattern.compile(DAY_FORMAT);
    private String year;
    private String month;
    private String day;

    private static void validateYearFormat(String year){
        if(!YEAR_PATTERN.matcher(year).matches()){
            throw new MemberException(MemberErrorCode.INVALID_DATE_FORMAT);
        }
    }
    private static void validateMonthFormat(String month){
        if(!MONTH_PATTERN.matcher(month).matches()){
            throw new MemberException(MemberErrorCode.INVALID_DATE_FORMAT);
        }
    }
    private static void validateDayFormat(String day){
        if(!DAY_PATTERN.matcher(day).matches()){
            throw new MemberException(MemberErrorCode.INVALID_DATE_FORMAT);
        }
    }
}
