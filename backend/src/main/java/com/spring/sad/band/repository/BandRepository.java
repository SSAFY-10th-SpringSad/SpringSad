package com.spring.sad.band.repository;

import com.spring.sad.band.domain.Band;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BandRepository extends JpaRepository<Band, Long> {
}
