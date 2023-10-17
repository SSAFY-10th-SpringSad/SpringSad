package com.spring.sad.member.domain;

import com.spring.sad.band.domain.Band;
import com.spring.sad.global.domain.BaseEntity;
import com.spring.sad.profile.domain.Profile;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class MemberBand extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_band_id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "band_id", nullable = false)
    private Band band;

    @Builder
    public MemberBand(
            Member member,
            Profile profile,
            Band band) {
        addRelatedMember(member);
        addRelatedProfile(profile);
        addRelatedBand(band);
    }

    private void addRelatedMember(Member member) {
        this.member = member;
        member.getMemberBandList().add(this);
    }

    private void addRelatedProfile(Profile profile) {
        this.profile = profile;
        profile.getMemberBandList().add(this);
    }

    private void addRelatedBand(Band band) {
        this.band = band;
        band.getMemberBandList().add(this);
    }
}
