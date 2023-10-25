package com.spring.sad.member.repository;

import com.spring.sad.member.domain.Member;
import com.spring.sad.member.domain.embbeded.PhoneNumber;
import com.spring.sad.member.domain.embbeded.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByEmail(Email email);

    boolean existsByPhoneNumber(PhoneNumber phoneNumber);

    Optional<Member> findByEmail(Email email);
    Optional<Member> findByPhoneNumber(PhoneNumber phoneNumber);
}