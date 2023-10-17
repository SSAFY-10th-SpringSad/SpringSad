package com.spring.sad.post.domain;

import com.spring.sad.band.domain.Band;
import com.spring.sad.comment.domain.Comment;
import com.spring.sad.global.domain.BaseEntity;
import com.spring.sad.member.domain.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "band_id")
    private Band band;

    @Column(nullable = false)
    private String content;

    private boolean hasImage;

    private int hit;

    @OneToMany(mappedBy = "post")
    private List<PostTag> postTagList = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<PostImage> postImageList = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<Comment> commentList = new ArrayList<>();

    @Builder public Post(
            Member member,
            Band band,
            String content,
            boolean hasImage,
            int hit,
            List<PostTag> postTagList,
            List<PostImage> postImageList,
            List<Comment> commentList) {
        this.content = content;
        this.hasImage = hasImage;
        this.hit = hit;
        this.postTagList = postTagList;
        this.postImageList = postImageList;
        this.commentList = commentList;
        addRelatedMember(member);
        addRelatedBand(band);
    }

    private void addRelatedMember(Member member) {
        this.member = member;
        member.getPostList().add(this);
    }

    private void addRelatedBand(Band band) {
        this.band = band;
        band.getPostList().add(this);
    }
}
