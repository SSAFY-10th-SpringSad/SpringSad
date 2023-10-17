package com.spring.sad.profile.domain;

import com.spring.sad.member.domain.Member;
import com.spring.sad.member.domain.MemberBand;
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
public class Profile {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String name;

    @Column(nullable = false)
    private String imgSrc;

    private boolean isRepresentation;

    @OneToMany(mappedBy = "profile")
    private List<MemberBand> memberBandList = new ArrayList<>();

    @Builder
    public Profile(
            int id,
            String name,
            String imgSrc,
            boolean isDefault,
            Member member) {
        this.id = id;
        this.name = name;
        this.imgSrc = imgSrc;
        this.isRepresentation = isDefault;
        addRelatedMember(member);
    }

    private void addRelatedMember(Member member) {
        this.member = member;
        member.getProfileList().add(this);
    }
}
