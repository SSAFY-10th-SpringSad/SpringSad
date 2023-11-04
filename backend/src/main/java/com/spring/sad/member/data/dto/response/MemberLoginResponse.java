package com.spring.sad.member.data.dto.response;

import com.spring.sad.member.domain.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MemberLoginResponse {
    private long memberId;
    private String name;
    private MemberLoginResponse(Member member) {
        this.memberId = member.getId();
        this.name = member.getName();
    }

    public static MemberLoginResponse toResponse(Member member) {
        return new MemberLoginResponse(member);
    }
}
