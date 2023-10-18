package com.spring.sad.band.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryId;

    private String categoryName;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Band> bands = new ArrayList<>();

    @Builder
    public Category(String categoryName) {
        this.categoryName = categoryName;
    }
}
