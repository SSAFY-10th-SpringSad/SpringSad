package com.spring.sad.member.service;

import com.spring.sad.member.dto.request.MemberSignupByCellPhoneRequest;
import com.spring.sad.member.dto.request.MemberSignupByEmailRequest;
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
    public void signupByCellPhone(MemberSignupByCellPhoneRequest request) {
        if (memberRepository.existsByCellPhone(request.getCellPhone())) {
            throw new MemberException(MemberErrorCode.CELL_PHONE_ALREADY_EXISTS);
        }
        memberRepository.save(request.toMember());
    }

    @Transactional
    public void signupByEmail(MemberSignupByEmailRequest request) {
        if (memberRepository.existsByEmail(request.getEmail())) {
            throw new MemberException(MemberErrorCode.EMAIL_ALREADY_EXISTS);
        }
        memberRepository.save(request.toMember());
    }
}
