package com.spring.sad.member.dto.request;

import com.spring.sad.member.domain.Member;
import com.spring.sad.member.domain.embedded.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class RequestMemberLoginByEmail {
    @NotBlank(message = MessageComment.NEED_EMAIL)
    private String email;

    @NotBlank(message = MessageComment.NEED_PASSWORD)
    @Pattern(regexp = MessageComment.PASSWORD_REGEXP, message = MessageComment.PASSWORD_PATTERN)
    private String password;

    public Member toMember() {
        return Member.builder()
                .email(Email.from(email))
                .password(password)
                .build();
    }
}
