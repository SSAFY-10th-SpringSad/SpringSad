package com.spring.sad.album.domain;

import com.spring.sad.BaseTimeEntity;
import com.spring.sad.image.domain.AlbumImage;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Album extends BaseTimeEntity {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int albumId;

    @Column(nullable = false)
    private int bandId;

    @OneToMany(mappedBy = "album", fetch = FetchType.LAZY)
    private List<AlbumImage> albumImages = new ArrayList<>();

    @Builder
    public Album(int albumId, int bandId){
        this.albumId = albumId;
        this.bandId = bandId;
    }
}
