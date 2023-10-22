package com.spring.sad.member.dto.request;

import com.spring.sad.member.domain.Member;
import com.spring.sad.member.domain.embedded.Email;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class RequestMemberSignUpByEmailDto extends RequestMemberDto {
    private String email;

    @Override
    public Member toMember() {
        return Member.builder()
                .email(Email.from(email))
                .password(password)
                .name(name)
                .birthday(birthDate)
                .build();
    }
}
