package com.spring.sad.member.dto.requestDto;

import com.spring.sad.member.domain.Member;
import com.spring.sad.member.domain.embbeded.Birthday;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public abstract class RequestMemberDto {
    @NotBlank(message = "비밀번호는 필수 입력값입니다.")
    protected String password;

    @NotBlank(message = "이름은 필수 입력값입니다.")
    protected String name;

    @Embedded
    @NotBlank(message = "생년월일은 필수 입력값입니다.")
    @Pattern(regexp = "^(19[0-9][0-9]|20\\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$", message = "생년월일은 8자리로 입력하세요. ex)YYYYMMDD")
    protected Birthday birthday;

    //entity 변환
    public abstract Member toMember();
}
