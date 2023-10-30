package com.spring.sad.member.controller;

import com.spring.sad.member.data.dto.request.MemberLoginByEmailRequest;
import com.spring.sad.member.data.dto.request.MemberLoginByPhoneNumberRequest;
import com.spring.sad.member.data.dto.request.MemberSignupByEmailRequest;
import com.spring.sad.member.data.dto.request.MemberSignupByPhoneNumberRequest;
import com.spring.sad.member.data.dto.response.MemberLoginResponse;
import com.spring.sad.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "멤버 컨트롤러", description = "로그인 및 회원 가입")
@RequestMapping("/member")
@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;

    @Operation(summary = "이메일 가입", description = "이메일로 회원 가입하는 API입니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "회원 가입 성공"),
            @ApiResponse(responseCode = "400", description = "유효하지 않은 이메일 형식(MEMBER_01)"),
            @ApiResponse(responseCode = "400", description = "유효하지 않은 날짜 형식(MEMBER_03)"),
            @ApiResponse(responseCode = "400", description = "이미 존재하는 이메일(MEMBER_04)")
    })
    @PostMapping("/signup/email")
    public ResponseEntity<Void> signup(@Valid @RequestBody MemberSignupByEmailRequest request) {
        memberService.signupByEmail(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiResponses({
            @ApiResponse(responseCode = "201",  description = "회원 가입 성공"),
            @ApiResponse(responseCode = "400", description = "유효하지 않은 전화 번호 형식(MEMBER_02)"),
            @ApiResponse(responseCode = "400", description = "유효하지 않은 날짜 형식(MEMBER_03)"),
            @ApiResponse(responseCode = "400", description = "이미 존재하는 전화번호(MEMBER_05)"),
    })
    @Operation(summary = "전화 번호 가입", description = "전화 번호로 회원 가입하는 API입니다.")
    @PostMapping("/signup/phone")
    public ResponseEntity<Void> signup(@Valid @RequestBody MemberSignupByPhoneNumberRequest request) {
        memberService.signupByCellPhone(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "로그인 성공"),
            @ApiResponse(responseCode = "400", description = "로그인 실패(MEMBER_06)")
    })
    @Operation(summary = "이메일 로그인", description = "이메일로 로그인하는 API입니다.")
    @PostMapping("/login/email")
    public ResponseEntity<MemberLoginResponse> login(@RequestBody MemberLoginByEmailRequest request) {
        MemberLoginResponse response = memberService.loginByEmail(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "로그인 성공"),
            @ApiResponse(responseCode = "400", description = "로그인 실패(MEMBER_06)")
    })
    @Operation(summary = "전화 번호 로그인", description = "전화 번호로 로그인하는 API입니다.")
    @PostMapping("/login/phone")
    public ResponseEntity<MemberLoginResponse> login(@RequestBody MemberLoginByPhoneNumberRequest request) {
        MemberLoginResponse response = memberService.loginByPhoneNumber(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }



}
