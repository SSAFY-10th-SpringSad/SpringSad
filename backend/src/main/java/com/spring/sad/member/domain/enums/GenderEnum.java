package com.spring.sad.member.domain.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public enum GenderEnum {
    MALE("남"),
    FEMALE("여");

    private String value;

    GenderEnum(String value) {
        this.value = value;
    }
}
