package com.spring.sad.member.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 20)
    private String profileName;

    private String profileImg;

    private boolean isPrimaryProfile;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private final List<MemberBand> memberBands = new ArrayList<>();

    @Builder
    public Profile(String profileName, String profileImg, boolean isPrimaryProfile) {
        this.profileName = profileName;
        this.profileImg = profileImg;
        this.isPrimaryProfile = isPrimaryProfile;
    }
}
