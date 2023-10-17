package com.spring.sad.member.domain;

import com.spring.sad.band.domain.Band;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class MemberBand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberBands")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberBands")
    private Band band;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberBands")
    private Profile profile;

    @Builder
    public MemberBand(Member member, Band band, Profile profile) {
        addRelateMember(member);
        addRelateBand(band);
        addRelateProfile(profile);
    }

    private void addRelateMember(Member member) {
        this.member = member;
        member.getMemberBands().add(this);
    }

    private  void addRelateBand(Band band) {
        this.band = band;
        band.getMemberBands().add(this);
    }

    private void addRelateProfile(Profile profile) {
        this.profile = profile;
        profile.getMemberBands().add(this);
    }
}