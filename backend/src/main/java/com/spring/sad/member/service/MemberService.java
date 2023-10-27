package com.spring.sad.member.service;

import com.spring.sad.member.data.dto.request.MemberLoginByEmailRequest;
import com.spring.sad.member.data.dto.request.MemberSignupByEmailRequest;
import com.spring.sad.member.data.dto.request.MemberSignupByPhoneNumberRequest;
import com.spring.sad.member.domain.Member;
import com.spring.sad.member.domain.embbeded.Email;
import com.spring.sad.member.exception.MemberErrorCode;
import com.spring.sad.member.exception.MemberException;
import com.spring.sad.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

    @Transactional(readOnly = true)
    public Member loginByEmail(MemberLoginByEmailRequest request){
        Optional<Member> memberOptional = memberRepository.findByEmail(Email.from(request.getEmail()));

        if(memberOptional.isEmpty()){
            throw new MemberException(MemberErrorCode.INVALID_EMAIL);
        }

        Member member = memberOptional.get();
        if(!member.getPassword().equals(request.getPassword())){
            throw new MemberException((MemberErrorCode.WRONG_PASSWORD));
        }

        return member;
    }
}
