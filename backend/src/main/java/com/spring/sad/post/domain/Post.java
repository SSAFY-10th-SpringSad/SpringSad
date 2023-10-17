package com.spring.sad.post.domain;

import com.spring.sad.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Post extends BaseTimeEntity {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;
    @Column(nullable = false)
    private int bandId;
    @Column(nullable = false)
    private int memberId;
    @Column(nullable = false)
    private String context;

    private boolean hasImage;

    private int hit;
}
