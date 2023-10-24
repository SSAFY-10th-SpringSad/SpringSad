package com.spring.sad.member.controller;

import com.spring.sad.member.dto.request.RequestMemberSignUpByEmail;
import com.spring.sad.member.dto.request.RequestMemberSignUpByPhoneNumber;
import com.spring.sad.member.dto.response.ResponseMemberDto;
import com.spring.sad.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/member")
@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/phone-login")
    public ResponseEntity<ResponseMemberDto> loginByPhoneNumber(@RequestBody RequestMemberSignUpByPhoneNumber request) {
        ResponseMemberDto response = memberService.loginByPhoneNumber(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/email-login")
    public ResponseEntity<ResponseMemberDto> loginByEmail(@RequestBody RequestMemberSignUpByEmail request) {
        ResponseMemberDto response = memberService.loginByEmail(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/phone-sign-up")
    public ResponseEntity<ResponseMemberDto> signUpByPhoneNumber(@RequestBody RequestMemberSignUpByPhoneNumber request) {
        ResponseMemberDto response = memberService.signUpByPhoneNumber(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/email-sign-up")
    public ResponseEntity<ResponseMemberDto> signUpByEmail(@RequestBody RequestMemberSignUpByEmail request) {
        ResponseMemberDto response = memberService.signUpByEmail(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
