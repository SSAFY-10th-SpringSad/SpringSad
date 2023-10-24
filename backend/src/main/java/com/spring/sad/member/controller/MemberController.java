package com.spring.sad.member.controller;

import com.spring.sad.member.dto.request.MemberSignupByCellPhoneRequest;
import com.spring.sad.member.dto.request.MemberSignupByEmailRequest;
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

    @PostMapping("/signup/email")
    public ResponseEntity<Void> signup(@RequestBody MemberSignupByEmailRequest request) {
        memberService.signupByEmail(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/signup/cellphone")
    public ResponseEntity<Void> signup(@RequestBody MemberSignupByCellPhoneRequest request) {
        memberService.signupByCellPhone(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
