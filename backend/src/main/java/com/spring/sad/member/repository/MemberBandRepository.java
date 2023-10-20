package com.spring.sad.member.repository;

import com.spring.sad.member.domain.MemberBand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberBandRepository extends JpaRepository<MemberBand, Long> {
}
