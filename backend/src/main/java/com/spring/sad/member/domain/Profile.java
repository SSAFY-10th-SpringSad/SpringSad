package com.spring.sad.member.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profiles")
    private Member member;

    @Column(nullable = false, length = 20)
    private String profileName;

    @Column(nullable = false, length = 200)
    private String profileImg;

    private Boolean profileDefault;

    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private List<MemberBand> memberBands = new ArrayList<>();

    @Builder
    public Profile(String profileName, String profileImg) {
        this.profileName = profileName;
        this.profileImg = profileImg;
    }
}
