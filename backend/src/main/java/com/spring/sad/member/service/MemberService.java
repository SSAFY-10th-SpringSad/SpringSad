package com.spring.sad.member.service;

import com.spring.sad.member.data.dto.request.MemberSignupByPhoneNumberRequest;
import com.spring.sad.member.data.dto.request.MemberSignupByEmailRequest;
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
}
