package com.spring.sad.member.controller;

import com.spring.sad.member.dto.requestDto.RequestMemberSignUpByCellPhoneDto;
import com.spring.sad.member.dto.requestDto.RequestMemberSignUpByEmailDto;
import com.spring.sad.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor //@Autowired를 사용하지 않고 의존성 주입
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;
    @PostMapping("/signup/email")
    public ResponseEntity<Void> signUpByEmail(@RequestBody RequestMemberSignUpByEmailDto request){
        memberService.signUpByEmail(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/signup/cellphone")
    public ResponseEntity<Void> signUpByCellPhone(@RequestBody RequestMemberSignUpByCellPhoneDto request){
        memberService.signUpByCellPhone(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
