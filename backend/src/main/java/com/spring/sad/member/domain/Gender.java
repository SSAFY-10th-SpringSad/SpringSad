package com.spring.sad.member.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public enum Gender {
    MALE("남"),
    FEMALE("여");

    private String value;

    Gender(String value) {
        this.value = value;
    }
}
