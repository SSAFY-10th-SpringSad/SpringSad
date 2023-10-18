package com.spring.sad.image.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Image{
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imgId;

    @Column(nullable = false)
    private String imgSrc;

    @OneToMany(mappedBy = "image", fetch = FetchType.LAZY)
    private List<PostImage> postImages = new ArrayList<>();

    @Builder
    public Image(int imgId, String imgSrc){
        this.imgId = imgId;
        this.imgSrc = imgSrc;
    }
}
