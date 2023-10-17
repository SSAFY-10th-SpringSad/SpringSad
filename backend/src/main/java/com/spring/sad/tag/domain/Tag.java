package com.spring.sad.tag.domain;

import com.spring.sad.post.domain.PostTag;
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
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private int id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "tag")
    private List<PostTag> postTagList = new ArrayList<>();

    @Builder public Tag(String name) {
        this.name = name;
    }
}
