package com.spring.sad.member.dto.request;

import com.spring.sad.member.domain.Member;
import com.spring.sad.member.domain.embedded.PhoneNumber;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class RequestMemberLoginByPhoneNumber {
    @NotBlank(message = "전화번호는 필수 입력 값입니다.")
    private String phoneNumber;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Pattern(regexp = "(?=,*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀 번호는 8~16자 영문 대, 소문자, 숫자, 특수 문자를 사용해주세요.")
    private String password;

    public Member toMember() {
        return Member.builder()
                .phoneNumber(PhoneNumber.from(phoneNumber))
                .password(password)
                .build();
    }
}
