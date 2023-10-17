package com.spring.sad.band.domain.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public enum VisibilityEnum {
    PUBLIC("공개"),
    NAMEONLY("밴드명 공개"),
    PRIVATE("비공개");

    private String value;

    VisibilityEnum(String value) {
        this.value = value;
    }
}
