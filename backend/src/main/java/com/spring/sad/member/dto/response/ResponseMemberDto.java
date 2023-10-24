package com.spring.sad.member.dto.response;

import com.spring.sad.member.domain.Member;
import com.spring.sad.member.domain.embedded.Email;
import com.spring.sad.member.domain.embedded.PhoneNumber;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ResponseMemberDto {
    private long id;
    private String name;

    private ResponseMemberDto(Member member) {
        this.id = member.getMemberId();
        this.name = member.getName();
    }

    public static ResponseMemberDto of(Member member) {
        return new ResponseMemberDto(member);
    }
}
