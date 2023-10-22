package com.spring.sad.member.dto.request;

import com.spring.sad.member.domain.Member;
import com.spring.sad.member.domain.embbeded.BirthDate;
import com.spring.sad.member.domain.embbeded.Email;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class MemberSignupByEmailRequest extends MemberSignupRequest{
    private String email;

    public Member toMember() {
        return Member.builder()
                .email(Email.from(email))
                .password(password)
                .name(name)
                .birthDate(BirthDate.of(
                        year,
                        month,
                        day))
                .build();
    }
}
