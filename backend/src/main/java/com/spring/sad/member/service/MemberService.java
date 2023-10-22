package com.spring.sad.member.service;

import com.spring.sad.member.domain.Member;
import com.spring.sad.member.dto.request.RequestMemberSignUpByEmail;
import com.spring.sad.member.dto.request.RequestMemberSignUpByPhoneNumber;
import com.spring.sad.member.dto.response.ResponseMemberDto;
import com.spring.sad.member.exception.MemberErrorCode;
import com.spring.sad.member.exception.MemberException;
import com.spring.sad.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;


    @Transactional
    public ResponseMemberDto signUpByEmail(RequestMemberSignUpByEmail request) {
        if(memberRepository.existsByEmail(request.toMember().getEmail()))
            throw new MemberException(MemberErrorCode.DUPLICATE_EMAIL);

        Member member = memberRepository.save(request.toMember());
        return ResponseMemberDto.of(member);
    }

    @Transactional
    public ResponseMemberDto signUpByPhoneNumber(RequestMemberSignUpByPhoneNumber request) {
        if(memberRepository.existsByPhoneNumber(request.toMember().getPhoneNumber()))
            throw new MemberException(MemberErrorCode.DUPLICATE_PHONE_NUMBER);

        Member member = memberRepository.save(request.toMember());
        return ResponseMemberDto.of(member);
    }

    public ResponseMemberDto loginByPhoneNumber(RequestMemberSignUpByPhoneNumber request) {
        Member requestMember = request.toMember();
        Member member = memberRepository.findByPhoneNumber(requestMember.getPhoneNumber())
                .orElseThrow(()->
                    new MemberException(MemberErrorCode.LOGIN_FAILED));

        if(!requestMember.getPassword().equals(member.getPassword()))
            throw new MemberException(MemberErrorCode.LOGIN_FAILED);

        return ResponseMemberDto.of(member);
    }

    public ResponseMemberDto loginByEmail(RequestMemberSignUpByEmail request) {
        Member requestMember = request.toMember();
        Member member = memberRepository.findByEmail(requestMember.getEmail())
                .orElseThrow(() ->
                        new MemberException(MemberErrorCode.LOGIN_FAILED));

        if(!requestMember.getPassword().equals(member.getPassword()))
            throw new MemberException(MemberErrorCode.LOGIN_FAILED);

        return ResponseMemberDto.of(member);
    }
}
