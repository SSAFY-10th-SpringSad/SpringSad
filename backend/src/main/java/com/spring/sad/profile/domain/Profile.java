package com.spring.sad.profile.domain;

import com.spring.sad.BaseTimeEntity;
import com.spring.sad.band.domain.Band;
import com.spring.sad.member.domain.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Profile{
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int profileId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String img;
    private boolean isDefault;

    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private List<Band> bands = new ArrayList<>();

    @Builder
    public Profile(int profileId, Member member, String name, String img, boolean isDefault){
        this.profileId = profileId;
        this.member = member;
        this.name = name;
        this.img = img;
        this.isDefault = isDefault;
    }
}
