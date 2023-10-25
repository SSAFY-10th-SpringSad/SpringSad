package com.spring.sad.member.repository;

import com.spring.sad.member.domain.Member;
import com.spring.sad.member.domain.embbeded.PhoneNumber;
import com.spring.sad.member.domain.embbeded.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByEmail(Email email);

    boolean existsByCellPhone(PhoneNumber phoneNumber);
}