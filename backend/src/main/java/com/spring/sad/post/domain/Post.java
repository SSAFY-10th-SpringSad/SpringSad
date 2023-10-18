package com.spring.sad.post.domain;

import com.spring.sad.band.domain.Band;
import com.spring.sad.global.domain.BaseEntity;
import com.spring.sad.member.domain.Member;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "band_id")
    private Band band;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String postContent;
    private Boolean postHasImage;
    private int postHit;

    @OneToMany(mappedBy = "post")
    private List<PostTag> postTags = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<PostImage> postImages = new ArrayList<>();

    @Builder
    public Post(Band band,
                Member member,
                String postContent,
                Boolean postHasImage,
                int postHit,
                List<PostTag> postTags,
                List<Comment> comments) {
        this.band = band;
        this.member = member;
        this.postContent = postContent;
        this.postHasImage = postHasImage;
        this.postHit = postHit;
        this.postTags = postTags;
        this.comments = comments;
        addRelateMember(member);
        addRelateBand(band);
    }

    private void addRelateMember(Member member) {
        this.member = member;
        member.getPosts().add(this);
    }

    private void addRelateBand(Band band) {
        this.band = band;
        band.getPosts().add(this);
    }
}
