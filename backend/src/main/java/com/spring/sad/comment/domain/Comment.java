package com.spring.sad.comment.domain;

import com.spring.sad.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseTimeEntity {
    @Id
    @Column(nullable = false)
    private int commentId;

    @Column(nullable = false)
    private int postID;

    @Column(nullable = false)
    private int authorId;

    @Column(nullable = false)
    private String content;
}
