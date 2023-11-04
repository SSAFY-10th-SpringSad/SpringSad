package com.spring.sad.member.data.dto.common;

import com.spring.sad.member.domain.MemberBand;
import com.spring.sad.member.domain.Profile;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class MemberProfileDetails {
    private long profileId;
    private String profileName;
    private String profileImg;
    private boolean isPrimaryProfile;
    private List<ProfileBandDetails> profileBandDetailsList = new ArrayList<>();

    public static MemberProfileDetails from(Profile profile) {
        MemberProfileDetails memberProfileDetails = MemberProfileDetails.builder()
                .profileId(profile.getId())
                .profileName(profile.getProfileName())
                .profileImg(profile.getProfileImg())
                .isPrimaryProfile(profile.isPrimaryProfile())
                .build();

        profile.getMemberBands().stream()
                .map(MemberBand::getBand)
                .map(ProfileBandDetails::from)
                .forEach(memberProfileDetails.profileBandDetailsList::add);

        return memberProfileDetails;
    }
}
