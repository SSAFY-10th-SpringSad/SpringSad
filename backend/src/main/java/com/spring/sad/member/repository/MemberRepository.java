package com.spring.sad.member.repository;

import com.spring.sad.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer>{
}
