package com.spring.sad.album.domain;

import com.spring.sad.band.domain.Band;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long albumId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "albums")
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
