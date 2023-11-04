package com.spring.sad.band.domain;

import com.spring.sad.album.domain.Album;
import com.spring.sad.image.domain.Image;
import com.spring.sad.member.domain.MemberBand;
import com.spring.sad.post.domain.Post;
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
public class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    private String bandName;

    private String bandCover;

    @Enumerated(EnumType.STRING)
    private Visibility bandVisibility;

    @OneToMany(mappedBy = "band", fetch = FetchType.LAZY)
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "band", fetch = FetchType.LAZY)
    private List<MemberBand> memberBands = new ArrayList<>();

    @OneToMany(mappedBy = "band", fetch = FetchType.LAZY)
    private List<Album> albums = new ArrayList<>();

    @OneToMany(mappedBy = "band", fetch = FetchType.LAZY)
    private List<Image> images = new ArrayList<>();

    @Builder
    public Band(
            String bandName,
            String bandCover,
            Visibility bandVisibility,
            Category category
    ) {
        this.bandName = bandName;
        this.bandCover = bandCover;
        this.bandVisibility = bandVisibility;
        addRelateCategory(category);
    }

    private void addRelateCategory(Category category) {
        this.category = category;
        category.getBands().add(this);
    }
}
