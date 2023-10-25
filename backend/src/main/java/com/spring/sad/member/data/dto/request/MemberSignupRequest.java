package com.spring.sad.member.data.dto.request;

import com.spring.sad.member.annotation.birthdate.ValidBirthdate;
import com.spring.sad.member.data.vo.Birthdate;
import com.spring.sad.member.domain.Member;
import lombok.Getter;

@Getter
public abstract class MemberSignupRequest {
    protected String password;
    protected String name;
    @ValidBirthdate
    protected Birthdate birthdate;

    public abstract Member toMember();
}
