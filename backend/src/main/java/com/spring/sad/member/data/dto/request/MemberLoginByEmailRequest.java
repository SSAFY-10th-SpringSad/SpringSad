package com.spring.sad.member.data.dto.request;

import com.spring.sad.member.domain.Member;
import com.spring.sad.member.domain.embbeded.Email;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class MemberLoginByEmailRequest {
    private String email;
    private String password;

    public Member toMember() {
        return Member.builder()
                .email(Email.from(email))
                .password(password)
                .build();
    }
}
