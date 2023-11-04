package com.spring.sad.member.domain;

import com.spring.sad.band.domain.Band;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class MemberBand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "band_id")
    private Band band;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
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

    private void removeRelateProfile() {
        if (this.profile != null)
            this.profile.getMemberBands().remove(this);
    }

    public void changeProfile(Profile profile) {
        removeRelateProfile();
        addRelateProfile(profile);
    }
}