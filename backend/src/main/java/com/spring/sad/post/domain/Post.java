package com.spring.sad.post.domain;

import com.spring.sad.BaseTimeEntity;
import com.spring.sad.band.domain.Band;
import com.spring.sad.comment.domain.Comment;
import com.spring.sad.image.domain.PostImage;
import com.spring.sad.member.domain.Member;
import com.spring.sad.tag.domain.PostTag;
import jakarta.persistence.*;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

public class Post extends BaseTimeEntity {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "band_id")
    private Band band;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    @Column(nullable = false)
    private String context;
    private boolean hasImage;
    private int hit;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    private List<PostImage> postImages = new ArrayList<>();

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    private List<PostTag> postTags = new ArrayList<>();

    @Builder
    public Post(int postId, Band band, Member member, String context, boolean hasImage, int hit){
        this.postId = postId;
        this.band = band;
        this.member = member;
        this.context = context;
        this.hasImage = hasImage;
        this.hit = hit;
    }
}
