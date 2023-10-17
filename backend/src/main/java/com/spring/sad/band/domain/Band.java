package com.spring.sad.band.domain;

import com.spring.sad.album.domain.Album;
import com.spring.sad.category.domain.Category;
import com.spring.sad.image.domain.Image;
import com.spring.sad.member.domain.MemberBand;
import com.spring.sad.post.domain.Post;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.nio.channels.FileLock;
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
    private String name;

    private String cover;

    private String visibility;

    @OneToMany(mappedBy = "band", fetch = FetchType.LAZY)
    private List<Post> postList = new ArrayList<>();

    @OneToMany(mappedBy = "memberBand", fetch = FetchType.LAZY)
    private List<MemberBand> memberBandList = new ArrayList<>();

    @OneToMany(mappedBy = "album",fetch = FetchType.LAZY)
    private List<Album> albumList = new ArrayList<>();

    @OneToMany(mappedBy = "image", fetch = FetchType.LAZY)
    private List<Image> imageList = new ArrayList<>();

    public Band(
            int id,
            Category category,
            String name,
            String cover,
            String visibility) {

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
