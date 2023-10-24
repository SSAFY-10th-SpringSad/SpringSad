package com.spring.sad.member.dto.requestDto;

import com.spring.sad.member.domain.Member;
import com.spring.sad.member.domain.embbeded.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RequestMemberSignUpByEmailDto extends RequestMemberDto{
    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    private String email;
    @Override
    public Member toMember() {
        return Member.builder()
                .email(Email.from(email))
                .name(name)
                .birthday(birthday)
                .password(password)
                .build();
    }
}
