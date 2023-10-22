package com.spring.sad.member.controller;

import com.spring.sad.member.dto.request.RequestMemberDto;
import com.spring.sad.member.dto.response.ResponseMemberDto;
import com.spring.sad.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/member")
@RequiredArgsConstructor
@RestController
public class MemberController {
    private MemberService memberService;

    // 페이지 이동 GET 어케?

    @PostMapping("/phone-login")
    public ResponseEntity<ResponseMemberDto> loginByPhoneNumber(@RequestBody RequestMemberDto request) {
        ResponseMemberDto response = memberService.loginByPhoneNumber(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/email-login")
    public ResponseEntity<ResponseMemberDto> loginByEmail(@RequestBody RequestMemberDto request) {
        ResponseMemberDto response = memberService.loginByEmail(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/phone-sign-up")
    public ResponseEntity<ResponseMemberDto> signUpByPhoneNumber(@RequestBody RequestMemberDto request) {
        ResponseMemberDto response = memberService.signUpByPhoneNumber(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/email-sign-up")
    public ResponseEntity<ResponseMemberDto> signUpByEmail(@RequestBody RequestMemberDto request) {
        ResponseMemberDto response = memberService.signUpByEmail(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
