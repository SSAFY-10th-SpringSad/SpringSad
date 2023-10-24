package com.spring.sad.member.dto.requestDto;

import com.spring.sad.member.domain.Member;
import com.spring.sad.member.domain.embbeded.CellPhone;
import jakarta.validation.constraints.NotBlank;

public class RequestMemberSignUpByCellPhoneDto extends RequestMemberDto{
    @NotBlank(message = "전화번호는 필수 입력 값입니다.")
    private String cellPhone;

    @Override
    public Member toMember() {
        return Member.builder()
                .cellPhone(CellPhone.from(cellPhone))
                .name(name)
                .password(password)
                .birthday(birthday)
                .build();
    }
}
