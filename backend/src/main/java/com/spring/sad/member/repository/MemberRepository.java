package com.spring.sad.member.repository;

import com.spring.sad.member.domain.Member;
import com.spring.sad.member.domain.embedded.Email;
import com.spring.sad.member.domain.embedded.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // 회원 가입 시 중복 검사
    boolean existsByEmail(Email email);
    boolean existsByPhoneNumber(PhoneNumber phoneNumber);

    // 로그인 시 회원 정보 가져오기
    Optional<Member> findByEmail(Email email);
    Optional<Member> findByPhoneNumber(PhoneNumber phoneNumber);
}