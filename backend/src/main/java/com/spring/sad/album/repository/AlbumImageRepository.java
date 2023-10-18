package com.spring.sad.album.repository;

import com.spring.sad.album.domain.AlbumImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumImageRepository extends JpaRepository<AlbumImage, Long> {
}
