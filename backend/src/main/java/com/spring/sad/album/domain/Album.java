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
@Getter
@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "band_id")
    private Band band;

    @OneToMany(mappedBy = "album", fetch = FetchType.LAZY)
    private List<AlbumImage> albumImages = new ArrayList<>();

    @Builder
    public Album(Band band) {
        addRelateBand(band);
    }

    private void addRelateBand(Band band) {
        this.band = band;
        band.getAlbums().add(this);
    }
}
