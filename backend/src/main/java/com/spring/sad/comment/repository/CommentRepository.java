package com.spring.sad.comment.repository;

import com.spring.sad.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Comment findCommentByCommentId(int commentId);

    List<Comment> findCommentByPostId(int postId);

    List<Comment> findCommentByAuthorId(int authorId);
}
