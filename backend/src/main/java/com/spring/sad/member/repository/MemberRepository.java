package com.spring.sad.member.repository;

import com.spring.sad.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer>{
    Member findMemberById(String id);

    List<Member> findMemberByName(String name);

    List<Member> findMemberByEmail(String email);

    List<Member> findMemberByCellPhone(String cellPhone);

    List<Member> findMemberByGender(String gender);

    List<Member> findMemberByBirthday(String birthday);

    List<Member> findMemberByRegDate(String regDate);

    List<Member> findMemberByModDate(String modDate);
}
