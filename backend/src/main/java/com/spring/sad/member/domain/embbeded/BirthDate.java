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
public class BirthDate {
    private static final String YEAR_FORMAT = "^\\d{4}$\n";
    private static final String MONTH_FORMAT = "^(0?[1-9]|1[0-2])$\n";
    private static final String DAY_FORMAT = "^(0?[1-9]|[12][0-9]|3[01])$\n";

    private static final Pattern YEAR_PATTERN = Pattern.compile(YEAR_FORMAT);
    private static final Pattern MONTH_PATTERN = Pattern.compile(MONTH_FORMAT);
    private static final Pattern DAY_PATTERN = Pattern.compile(DAY_FORMAT);

    @Column(nullable = false)
    private String year;
    @Column(nullable = false)
    private String month;
    @Column(nullable = false)
    private String day;

    private BirthDate(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static BirthDate of(String year, String month, String day) {
        validationBirthFormat(year, month, day);
        return new BirthDate(year, month, day);
    }

    private static void validationBirthFormat(String year, String month, String day) {
        if (!YEAR_PATTERN.matcher(year).matches()) {
            throw new MemberException(MemberErrorCode.BIRTH_DATE_YEAR_IS_NOT_VALID);
        }
        if (!MONTH_PATTERN.matcher(year).matches()) {
            throw new MemberException(MemberErrorCode.BIRTH_DATE_MONTH_IS_NOT_VALID);
        }
        if (!DAY_PATTERN.matcher(year).matches()) {
            throw new MemberException(MemberErrorCode.BIRTH_DATE_DAY_IS_NOT_VALID);
        }
    }
}
