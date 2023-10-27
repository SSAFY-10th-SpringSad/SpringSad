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
public class MemberLoginByPhoneNumberRequest {
    private String phoneNumber;
    private String password;

    public Member toMember() {
        return Member.builder()
                .phoneNumber(PhoneNumber.from(phoneNumber))
                .password(password)
                .build();
    }
}
