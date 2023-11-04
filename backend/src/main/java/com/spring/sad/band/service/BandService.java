package com.spring.sad.band.service;

import com.spring.sad.band.domain.Band;
import com.spring.sad.band.repository.BandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BandService {
    private final BandRepository bandRepository;
    public Optional<Band> findById(long bandId) {
        return bandRepository.findById(bandId);
    }
}
