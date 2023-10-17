package com.spring.sad.band.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public enum Visibility {
    PUBLIC("공개"),
    PRIVATE("비공개"),
    NAMEONLY("밴드명 공개");

    private String value;

    Visibility(String value) {
        this.value = value;
    }
}
