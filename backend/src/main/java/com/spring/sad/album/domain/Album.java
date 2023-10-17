package com.spring.sad.album.domain;

import com.spring.sad.band.domain.Band;
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
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "band_id")
    private Band band;

    @OneToMany(mappedBy = "album", fetch = FetchType.LAZY)
    private List<AlbumImage> albumImageList = new ArrayList<>();

    @Builder
    public Album(int id, Band band) {
        this.id = id;
        addRelatedBand(band);
    }

    private void addRelatedBand(Band band) {
        this.band = band;
        band.getAlbumList().add(this);
    }
}
