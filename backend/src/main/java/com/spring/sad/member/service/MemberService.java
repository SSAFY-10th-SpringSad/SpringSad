package com.spring.sad.member.service;

import com.spring.sad.member.domain.Member;
import com.spring.sad.member.dto.request.RequestMemberDto;
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
    public ResponseMemberDto signUpByEmail(RequestMemberDto request) {
        if(memberRepository.existsByEmail(request.getEmail()))
            throw new MemberException(MemberErrorCode.DUPLICATE_EMAIL);

        Member member = memberRepository.save(request.toMember());
        return ResponseMemberDto.of(member);
    }

    @Transactional
    public ResponseMemberDto signUpByPhoneNumber(RequestMemberDto request) {
        if(memberRepository.existsByPhoneNumber(request.getPhoneNumber()))
            throw new MemberException(MemberErrorCode.DUPLICATE_PHONE_NUMBER);

        Member member = memberRepository.save(request.toMember());
        return ResponseMemberDto.of(member);
    }

    public ResponseMemberDto loginByPhoneNumber(RequestMemberDto request) {
        Member member = memberRepository.findByPhoneNumber(request.getPhoneNumber())
                .orElseThrow(()->
                    new MemberException(MemberErrorCode.LOGIN_FAILED));

        if(!request.getPassword().equals(member.getPassword()))
            throw new MemberException(MemberErrorCode.LOGIN_FAILED);

        return ResponseMemberDto.of(member);
    }

    public ResponseMemberDto loginByEmail(RequestMemberDto request) {
        Member member = memberRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new MemberException(MemberErrorCode.LOGIN_FAILED));

        if(!request.getPassword().equals(member.getPassword()))
            throw new MemberException(MemberErrorCode.LOGIN_FAILED);

        return ResponseMemberDto.of(member);
    }
}
