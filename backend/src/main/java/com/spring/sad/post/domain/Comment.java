package com.spring.sad.post.domain;

import com.spring.sad.global.domain.BaseEntity;
import com.spring.sad.member.domain.Member;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentId;

    private String commentContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Builder
    public Comment(String commentContent,
                   Member authorId,
                   Post postId) {
        this.commentContent = commentContent;
        addRelateMember(member);
        addRelatePost(post);
    }

    private void addRelateMember(Member member) {
        this.member = member;
        member.getComments().add(this);
    }

    private void addRelatePost(Post post) {
        this.post = post;
        post.getComments().add(this);
    }
}
