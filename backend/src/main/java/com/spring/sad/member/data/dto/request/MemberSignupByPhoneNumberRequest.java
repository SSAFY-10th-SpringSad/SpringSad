package com.spring.sad.member.data.dto.request;

import com.spring.sad.member.domain.Member;
import com.spring.sad.member.domain.embbeded.PhoneNumber;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class MemberSignupByPhoneNumberRequest extends MemberSignupRequest{
    private String phoneNumber;

    public Member toMember() {
        return Member.builder()
                .phoneNumber(PhoneNumber.from(phoneNumber))
                .password(password)
                .name(name)
                .birthDate(birthdate.toLocalDate())
                .build();
    }
}
