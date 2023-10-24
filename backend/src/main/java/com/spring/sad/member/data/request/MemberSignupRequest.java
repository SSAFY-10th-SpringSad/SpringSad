package com.spring.sad.member.data.request;

import com.spring.sad.member.domain.embbeded.Birthday;
import com.spring.sad.member.domain.embbeded.CellPhone;
import com.spring.sad.member.domain.embbeded.Email;
import com.spring.sad.member.enums.GenderEnum;
import jakarta.persistence.Embedded;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberSignupRequest {
    private int id;
    private String name;
    private String password;
    @Embedded
    private Email email;
    @Embedded
    private CellPhone cellPhone;
    private GenderEnum gender;
    @Embedded
    private Birthday birthday;
}
