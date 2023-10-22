package com.spring.sad.member.service;

import com.spring.sad.member.dto.request.MemberSignupByCellPhoneRequest;
import com.spring.sad.member.dto.request.MemberSignupByEmailRequest;
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
        memberRepository.save(request.toMember());
    }

    @Transactional
    public void signupByEmail(MemberSignupByEmailRequest request) {
        memberRepository.save(request.toMember());
    }
}
