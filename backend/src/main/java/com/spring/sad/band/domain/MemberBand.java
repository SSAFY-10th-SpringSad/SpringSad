package com.spring.sad.band.domain;

import com.spring.sad.BaseTimeEntity;
import com.spring.sad.member.domain.Member;
import com.spring.sad.profile.domain.Profile;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberBand extends BaseTimeEntity {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberBandId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "band_id")
    private Band band;

    @Builder
    public MemberBand(int memberBandId, Member member, Profile profile, Band band){
        this.memberBandId = memberBandId;
        this.member = member;
        this.profile = profile;
        this.band = band;
    }
}
