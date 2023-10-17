package com.spring.sad.band.repository;

import com.spring.sad.band.domain.Band;
import com.spring.sad.band.enums.VisibilityEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BandRepository extends JpaRepository<Band, Integer> {
    Band findBandById(int id);

    List<Band> findBandByCategoryId(int categoryId);

    List<Band> findBandByName(String name);

    List<Band> findBandByVisibility(VisibilityEnum visibilityEnum);
}
