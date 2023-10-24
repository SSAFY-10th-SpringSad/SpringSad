package com.spring.sad.member.service;

import com.spring.sad.member.domain.Member;
import com.spring.sad.member.dto.requestDto.RequestMemberSignUpByCellPhoneDto;
import com.spring.sad.member.dto.requestDto.RequestMemberSignUpByEmailDto;
import com.spring.sad.member.exception.MemberErrorCode;
import com.spring.sad.member.exception.MemberException;
import com.spring.sad.member.repository.MemberRepository;
import com.spring.sad.member.response.ResponseMemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    //이메일 중복 검사
    @Transactional //flush 날리기
    public ResponseMemberDto signUpByEmail(RequestMemberSignUpByEmailDto request){
        if(memberRepository.existsByEmail(request.toMember().getEmail())) {//dto를 entity 변환 후 email 가져오기
            throw new MemberException(MemberErrorCode.DUPLICATE_EMAIL);
        }
        Member member = memberRepository.save(request.toMember());
        return ResponseMemberDto.of(member); //id정도 날리기. test 때 사용하기 좋음
    }
    //전화번호 중복 검사
    @Transactional
    public ResponseMemberDto signUpByCellPhone(RequestMemberSignUpByCellPhoneDto request){
        if(memberRepository.existsByCellPhone(request.toMember().getCellPhone())) {
            throw new MemberException(MemberErrorCode.DUPLICATE_PHONE_NUMBER);
        }
        Member member = memberRepository.save(request.toMember());
        return ResponseMemberDto.of(member);
    }

    @Transactional(readOnly = true)
    public ResponseMemberDto loginByEmail(RequestMemberSignUpByEmailDto request){
        Member requestMember = request.toMember();
        Member member = memberRepository.findByEmail(requestMember.getEmail())
                .orElseThrow(() ->
                        new MemberException(MemberErrorCode.LOGIN_FAILED));//가져온 값이 null이면 exception 발생
        //password가 다르면
        if(!requestMember.getPassword().equals(member.getPassword())){
            throw new MemberException(MemberErrorCode.LOGIN_FAILED);
        }
        return ResponseMemberDto.of(member);
    }

    @Transactional(readOnly = true)
    public ResponseMemberDto loginByCellPhone(RequestMemberSignUpByCellPhoneDto request){
        Member requestMember = request.toMember();
        Member member = memberRepository.findByCellPhone(requestMember.getCellPhone())
                .orElseThrow(() ->
                        new MemberException(MemberErrorCode.LOGIN_FAILED));
        if(!requestMember.getPassword().equals(member.getPassword())){
            throw new MemberException(MemberErrorCode.LOGIN_FAILED);
        }
        return ResponseMemberDto.of(member);
    }
}
