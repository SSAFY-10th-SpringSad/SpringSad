package com.spring.sad.image.domain;

import com.spring.sad.BaseTimeEntity;
import com.spring.sad.album.domain.Album;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AlbumImage{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id")
    private Album album;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "img_id")
    private Image image;

    @Builder
    public AlbumImage(Album album, Image image){
        this.album = album;
        this.image = image;
    }
}
