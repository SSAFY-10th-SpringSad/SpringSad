package com.spring.sad.member.dto.request;

import com.spring.sad.member.domain.Member;
import com.spring.sad.member.domain.embbeded.BirthDate;
import com.spring.sad.member.domain.embbeded.CellPhone;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class MemberSignupByCellPhoneRequest extends MemberSignupRequest{
    private String cellPhone;

    public Member toMember() {
        return Member.builder()
                .cellPhone(CellPhone.from(cellPhone))
                .password(password)
                .name(name)
                .birthDate(BirthDate.of(
                        year,
                        month,
                        day))
                .build();
    }
}
