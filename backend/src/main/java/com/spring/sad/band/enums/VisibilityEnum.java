package com.spring.sad.band.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public enum VisibilityEnum {
    PUBLIC("공개"),
    PRIVATE("비공개"),
    NAMEONLY("밴드명 공개");

    private String value;
}
