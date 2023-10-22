package com.spring.sad.member.dto.request;

import com.spring.sad.member.domain.Member;
import com.spring.sad.member.domain.embedded.Email;
import com.spring.sad.member.domain.embedded.PhoneNumber;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class RequestMemberDto {
    @NotBlank(message = "이메일은 필수 입력 값 입니다.")
    private Email email;

    @NotBlank(message = "핸드폰 번호는 필수 입력 값 입니다.")
    private PhoneNumber phoneNumber;

    // Validation 비밀 번호 형식은 나중에
    @NotBlank(message = "비밀번호는 필수 입력 값 입니다.")
//    @Pattern(regexp = "(?=,*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀 번호는 8~16자 영문 대, 소문자, 숫자, 특수 문자를 사용해주세요.")
    private String password;

    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String name;

    @NotBlank(message = "생년월일은 필수 입력 값 입니다.")
    @DateTimeFormat(pattern = "yyyy-mm-dd", iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;

    public Member toMember() {
        if(this.getEmail() == null) {
            return Member.builder()
                    .phoneNumber(this.phoneNumber)
                    .name(this.name)
                    .password(this.password)
                    .birthday(this.birthDate)
                    .build();
        } else {
            return Member.builder()
                    .email(this.email)
                    .name(this.name)
                    .password(this.password)
                    .birthday(this.birthDate)
                    .build();
        }
    }
}
