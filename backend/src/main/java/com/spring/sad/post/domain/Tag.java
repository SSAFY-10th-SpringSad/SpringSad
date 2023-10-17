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
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tagId;

    private String name;

    @OneToMany(mappedBy = "tag")
    private List<PostTag> postTags = new ArrayList<>();

    @Builder
    public Tag(String name) {
        this.name = name;
    }
}
