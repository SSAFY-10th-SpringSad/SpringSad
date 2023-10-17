package com.spring.sad.band.domain;

import com.spring.sad.BaseTimeEntity;
import com.spring.sad.band.enums.VisibilityEnum;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "band")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Band extends BaseTimeEntity {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bandId;

    @Column(nullable = false)
    private int categoryId;

    @Column(nullable = false)
    private String name;

    private String coverImage;

    @Column(nullable = false)
    private VisibilityEnum visibility;

}
