package com.spring.sad.band.repository;

import com.spring.sad.band.domain.MemberBand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberBandRepository extends JpaRepository<MemberBand, Integer> {
}
