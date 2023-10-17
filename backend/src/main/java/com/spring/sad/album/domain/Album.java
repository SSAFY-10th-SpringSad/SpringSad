package com.spring.sad.album.domain;

import com.spring.sad.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Album extends BaseTimeEntity {
    @Column(nullable = false)
    private int albumId;

    @Column(nullable = false)
    private int bandId;
}
