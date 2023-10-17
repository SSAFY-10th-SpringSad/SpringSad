package com.spring.sad.band.domain;

import com.spring.sad.album.domain.Album;
import com.spring.sad.band.domain.enums.VisibilityEnum;
import com.spring.sad.category.domain.Category;
import com.spring.sad.image.domain.Image;
import com.spring.sad.member.domain.MemberBand;
import com.spring.sad.post.domain.Post;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(nullable = false)
    @NotBlank
    private String name;

    private String cover;

    private VisibilityEnum visibility;

    @OneToMany(mappedBy = "band")
    private List<Post> postList = new ArrayList<>();

    @OneToMany(mappedBy = "memberBand")
    private List<MemberBand> memberBandList = new ArrayList<>();

    @OneToMany(mappedBy = "album")
    private List<Album> albumList = new ArrayList<>();

    @OneToMany(mappedBy = "image")
    private List<Image> imageList = new ArrayList<>();

    public Band(
            int id,
            Category category,
            String name,
            String cover,
            VisibilityEnum visibility) {

        this.id = id;
        this.name = name;
        this.cover = cover;
        this.visibility = visibility;
        addRelatedCategory(category);
    }

    private void addRelatedCategory(Category category) {
        this.category = category;
        category.getBandList().add(this);
    }
}
