package com.spring.sad.member.dto.request;

import com.spring.sad.member.domain.Member;
import lombok.Getter;

@Getter
public abstract class MemberSignupRequest {
    protected String password;
    protected String name;
    protected String year;
    protected String month;
    protected String day;

    public abstract Member toMember();
}
