package com.spring.sad.member.controller;

import com.spring.sad.member.data.dto.request.MemberLoginByEmailRequest;
import com.spring.sad.member.data.dto.request.MemberLoginByPhoneNumberRequest;
import com.spring.sad.member.data.dto.request.MemberSignupByPhoneNumberRequest;
import com.spring.sad.member.data.dto.request.MemberSignupByEmailRequest;
import com.spring.sad.member.data.dto.response.MemberLoginResponse;
import com.spring.sad.member.service.MemberService;
import jakarta.validation.Valid;
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

    @PostMapping("/signup/email")
    public ResponseEntity<Void> signup(@Valid @RequestBody MemberSignupByEmailRequest request) {
        memberService.signupByEmail(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/signup/phone")
    public ResponseEntity<Void> signup(@Valid @RequestBody MemberSignupByPhoneNumberRequest request) {
        memberService.signupByCellPhone(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login/email")
    public ResponseEntity<MemberLoginResponse> login(@RequestBody MemberLoginByEmailRequest request) {
        MemberLoginResponse response = memberService.loginByEmail(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/login/phone")
    public ResponseEntity<MemberLoginResponse> login(@RequestBody MemberLoginByPhoneNumberRequest request) {
        MemberLoginResponse response = memberService.loginByPhoneNumber(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
