package com.spring.sad.image.repository;

import com.spring.sad.image.domain.AlbumImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumImageRepository extends JpaRepository<AlbumImage, Integer> {
}
