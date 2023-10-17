package com.spring.sad.comment.domain;


import com.spring.sad.global.domain.BaseEntity;
import com.spring.sad.member.domain.Member;
import com.spring.sad.post.domain.Post;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    private String content;

    @Builder public Comment(
            Member member, Post post, String content) {
        this.content = content;
        addRelatedMember(member);
        addRelatedPost(post);
    }

    private void addRelatedMember(Member member) {
        this.member = member;
        member.getCommentList().add(this);
    }

    private void addRelatedPost(Post post) {
        this.post = post;
        post.getCommentList().add(this);
    }
}
