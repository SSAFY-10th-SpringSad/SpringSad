package com.spring.sad.profile.domain;

import com.spring.sad.BaseTimeEntity;
import jakarta.persistence.*;

@Entity
public class Profile extends BaseTimeEntity {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int profileId;

    @Column(nullable = false)
    private int memberId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String img;
    private boolean isDefault;
}
