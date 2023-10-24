package com.spring.sad.member.data.vo;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Birthdate {
    private int year;
    private int month;
    private int day;

    public LocalDate toLocalDate() {
        return LocalDate.of(year, month, day);
    }
}
