package com.spring.sad.post.domain;

import com.spring.sad.tag.domain.Tag;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class PostTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_tag_id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @Builder public PostTag(Post post, Tag tag) {
        addRelatedPost(post);
        addRelatedTag(tag);
    }

    private void addRelatedPost(Post post) {
        this.post = post;
        post.getPostTagList().add(this);
    }

    private void addRelatedTag(Tag tag) {
        this.tag = tag;
        tag.getPostTagList().add(this);
    }
}
