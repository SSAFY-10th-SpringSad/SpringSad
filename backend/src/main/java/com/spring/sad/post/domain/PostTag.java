package com.spring.sad.post.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class PostTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postTags")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postTags")
    private Tag tag;

    @Builder
    public PostTag(Post post, Tag tag) {
        addRelatePost(post);
        addRelateTag(tag);
    }

    private void addRelatePost(Post post) {
        this.post = post;
        post.getPostTags().add(this);
    }

    private void addRelateTag(Tag tag) {
        this.tag = tag;
        tag.getPostTags().add(this);
    }
}