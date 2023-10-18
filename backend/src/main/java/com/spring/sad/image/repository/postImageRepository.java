package com.spring.sad.image.repository;

import com.spring.sad.image.domain.PostImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface postImageRepository extends JpaRepository<PostImage, Integer> {
}
