package com.spring.sad.image.domain;


import com.spring.sad.band.domain.Band;
import com.spring.sad.post.domain.PostImage;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "img_id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "band_id", nullable = false)
    private Band band;

    @Column(nullable = false)
    private String imgSrc;

    @OneToMany(mappedBy = "postImage")
    private List<PostImage> postImageList = new ArrayList<>();

    @Builder
    public Image(String imgSrc, Band band) {
        this.imgSrc = imgSrc;
        addRelatedBand(band);
    }

    private void addRelatedBand(Band band) {
        this.band = band;
        band.getImageList().add(this);
    }
}
