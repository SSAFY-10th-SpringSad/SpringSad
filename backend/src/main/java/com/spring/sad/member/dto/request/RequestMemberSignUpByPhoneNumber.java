package com.spring.sad.member.dto.request;

import com.spring.sad.member.domain.Member;
import com.spring.sad.member.domain.embedded.PhoneNumber;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class RequestMemberSignUpByPhoneNumber extends RequestMemberDto {
    private String phoneNumber;

    @Override
    public Member toMember() {
        return Member.builder()
                .phoneNumber(PhoneNumber.from(phoneNumber))
                .password(password)
                .name(name)
                .birthday(birthDate)
                .build();
    }
}
