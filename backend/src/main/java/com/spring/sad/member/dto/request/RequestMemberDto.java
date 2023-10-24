package com.spring.sad.member.dto.request;

import com.spring.sad.member.domain.Member;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
public abstract class RequestMemberDto {
    // Validation 비밀 번호 형식은 나중에
    @NotBlank(message = "비밀번호는 필수 입력 값 입니다.")
    @Pattern(regexp = "(?=,*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀 번호는 8~16자 영문 대, 소문자, 숫자, 특수 문자를 사용해주세요.")
    protected String password;

    @NotBlank(message = "이름은 필수 입력 값입니다.")
    protected String name;

    @NotBlank(message = "생년월일은 필수 입력 값 입니다.")
    @DateTimeFormat(pattern = "yyyy-mm-dd", iso = DateTimeFormat.ISO.DATE)
    protected LocalDate birthDate;

    public abstract Member toMember();
}
