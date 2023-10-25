package com.spring.sad.member.service;

import com.spring.sad.member.data.dto.request.MemberLoginByEmailRequest;
import com.spring.sad.member.data.dto.request.MemberLoginByPhoneNumberRequest;
import com.spring.sad.member.data.dto.request.MemberSignupByPhoneNumberRequest;
import com.spring.sad.member.data.dto.request.MemberSignupByEmailRequest;
import com.spring.sad.member.data.dto.response.MemberLoginResponse;
import com.spring.sad.member.domain.Member;
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
    public void signupByCellPhone(MemberSignupByPhoneNumberRequest request) {
        if (memberRepository.existsByPhoneNumber(request.toMember().getPhoneNumber())) {
            throw new MemberException(MemberErrorCode.PHONE_NUMBER_ALREADY_EXISTS);
        }
        memberRepository.save(request.toMember());
    }

    @Transactional
    public void signupByEmail(MemberSignupByEmailRequest request) {
        if (memberRepository.existsByEmail(request.toMember().getEmail())) {
            throw new MemberException(MemberErrorCode.EMAIL_ALREADY_EXISTS);
        }
        memberRepository.save(request.toMember());
    }

    public MemberLoginResponse loginByEmail(MemberLoginByEmailRequest request) {
        Member requestMember = request.toMember();
        Member member = memberRepository.findByEmail(requestMember.getEmail())
                .orElseThrow(()->
                        new MemberException(MemberErrorCode.LOGIN_FAILED));

        if(!requestMember.getPassword().equals(member.getPassword()))
            throw new MemberException(MemberErrorCode.LOGIN_FAILED);

        return MemberLoginResponse.of(member);
    }

    public MemberLoginResponse loginByPhoneNumber(MemberLoginByPhoneNumberRequest request) {
        Member requestMember = request.toMember();
        Member member = memberRepository.findByPhoneNumber(requestMember.getPhoneNumber())
                .orElseThrow(()->
                        new MemberException(MemberErrorCode.LOGIN_FAILED));

        if(!requestMember.getPassword().equals(member.getPassword()))
            throw new MemberException(MemberErrorCode.LOGIN_FAILED);

        return MemberLoginResponse.of(member);
    }
}
