package com.spring.sad.category.domain;

import com.spring.sad.band.domain.Band;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;

    @NotBlank
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Band> bandList = new ArrayList<>();

    @Builder public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
