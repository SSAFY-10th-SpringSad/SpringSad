package com.spring.sad.image.domain;

import com.spring.sad.album.domain.AlbumImage;
import com.spring.sad.band.domain.Band;
import com.spring.sad.post.domain.PostImage;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long imgId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "band_id")
    private Band band;

    private String imgSrc;

    @OneToMany(mappedBy = "image", fetch = FetchType.LAZY)
    private List<PostImage> postImages = new ArrayList<>();

    @Builder
    public Image(Band band, String imgSrc) {
        this.imgSrc = imgSrc;
        addRelateBand(band);
    }

    private void addRelateBand(Band band) {
        this.band = band;
        band.getImages().add(this);
    }
}
