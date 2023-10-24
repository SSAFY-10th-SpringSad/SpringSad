package com.spring.sad.member.response;

import com.spring.sad.member.domain.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ResponseMemberDto {
    private int id;
    private String name;
    private String password;

    private ResponseMemberDto(Member member){
        this.id = member.getId();
        this.name = member.getName();
        this.password = member.getPassword();
    }

    public static ResponseMemberDto of(Member member){
        return new ResponseMemberDto(member);
    }
}
