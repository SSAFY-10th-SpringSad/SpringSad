package com.spring.sad.band.domain;

import com.spring.sad.BaseTimeEntity;
import com.spring.sad.band.enums.VisibilityEnum;
import com.spring.sad.post.domain.Post;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Band extends BaseTimeEntity {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bandId;

    @Column(nullable = false)
    private int categoryId;

    @Column(nullable = false)
    private String name;

    private String coverImage;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VisibilityEnum visibility;

    @OneToMany(mappedBy = "band", fetch = FetchType.LAZY)
    private List<Post> posts = new ArrayList<>();

    @Builder
    public Band(int bandId, int categoryId, String name, String coverImage, VisibilityEnum visibility){
        this.bandId = bandId;
        this.categoryId = categoryId;
        this.name = name;
        this.coverImage = coverImage;
        this.visibility = visibility;
    }

}
