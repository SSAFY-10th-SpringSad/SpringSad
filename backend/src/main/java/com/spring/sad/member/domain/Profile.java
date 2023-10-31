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
    @JoinColumn(name = "memberId")
    private Member member;

    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private List<MemberBand> memberBands = new ArrayList<>();

    @Builder
    public Profile(
            Member member,
            String profileName,
            String profileImg,
            boolean isPrimaryProfile) {
        this.member = member;
        this.profileName = profileName;
        this.profileImg = profileImg;
        this.isPrimaryProfile = isPrimaryProfile;
    }
}
