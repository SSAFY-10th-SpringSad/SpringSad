package com.spring.sad.album.domain;

import com.spring.sad.image.domain.Image;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class AlbumImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_img_id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id")
    private Album album;

    @OneToOne(fetch = FetchType.LAZY)
    private Image image;

    @Builder
    public AlbumImage(Album album, Image image) {
        this.image = image;
        addRelatedAlbum(album);
    }

    private void addRelatedAlbum (Album album) {
        this.album = album;
        album.getAlbumImageList().add(this);
    }
}
