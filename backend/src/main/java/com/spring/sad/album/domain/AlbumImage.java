package com.spring.sad.album.domain;

import com.spring.sad.image.domain.Image;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.awt.*;

@Getter
@NoArgsConstructor
@Entity
public class AlbumImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long albumImgId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "albumImages")
    private Album album;

    @OneToOne(fetch = FetchType.LAZY)
    private Image image;

    @Builder
    public AlbumImage(Album album, Image image) {
        this.image = image;
        addRelateAlbum(album);
    }

    private void addRelateAlbum(Album album) {
        this.album = album;
        album.getAlbumImages().add(this);
    }
}
