package com.spring.sad.post.domain;

import com.spring.sad.image.domain.Image;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class PostImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_img_id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "img_id")
    private Image image;

    @Builder public PostImage (Post post, Image image) {
        addRelatedPost(post);
        addRelatedImage(image);
    }

    private void addRelatedPost(Post post) {
        this.post = post;
        post.getPostImageList().add(this);
    }

    private void addRelatedImage(Image image) {
        this.image = image;
        image.getPostImageList().add(this);
    }

}
