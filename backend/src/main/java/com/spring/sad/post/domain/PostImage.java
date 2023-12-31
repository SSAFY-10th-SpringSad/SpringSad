package com.spring.sad.post.domain;

import com.spring.sad.image.domain.Image;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class PostImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postImageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    private Image image;

    @Builder
    public PostImage(Post post, Image image) {
        addRelatePost(post);
        addRelateImage(image);
    }

    private void addRelatePost(Post post) {
        this.post = post;
        post.getPostImages().add(this);
    }

    private void addRelateImage(Image image) {
        this.image = image;
        image.getPostImages().add(this);
    }
}
