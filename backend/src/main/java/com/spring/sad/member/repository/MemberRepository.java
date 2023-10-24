package com.spring.sad.member.repository;

import com.spring.sad.member.domain.Member;
import com.spring.sad.member.domain.embbeded.CellPhone;
import com.spring.sad.member.domain.embbeded.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer>{
    //회원 가입 시 중복 검사
    boolean existsByEmail(Email email);
    boolean existsByCellPhone(CellPhone cellPhone);
    //로그인 시 회원 정보 가져오기
    Optional<Member> findByEmail(Email email); //NPE방지 위해 optional 사용
    Optional<Member> findByCellPhone(CellPhone cellPhone);
}
