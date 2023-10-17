package com.spring.sad.album.repository;

import com.spring.sad.album.domain.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
    //복합키는 어떻게?
}
