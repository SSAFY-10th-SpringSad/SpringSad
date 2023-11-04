package com.spring.sad.member.data.dto.common;

import com.spring.sad.member.domain.Member;
import com.spring.sad.member.domain.MemberBand;
import com.spring.sad.member.domain.Profile;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class ProfileDetails {
    private long profileId;
    private String profileName;
    private String profileImg;
    private boolean isPrimaryProfile;
    private List<BandDetails> bandDetailsList = new ArrayList<>();

    public static ProfileDetails from(Profile profile) {
        ProfileDetails profileDetails = ProfileDetails.builder()
                .profileId(profile.getId())
                .profileName(profile.getProfileName())
                .profileImg(profile.getProfileImg())
                .isPrimaryProfile(profile.isPrimaryProfile())
                .build();

        profile.getMemberBands().stream()
                .map(MemberBand::getBand)
                .map(BandDetails::from)
                .forEach(profileDetails.bandDetailsList::add);

        return profileDetails;
    }

    public Profile toProfile(Member member) {
        return Profile.builder()
                .member(member)
                .profileName(profileName)
                .profileImg(profileImg)
                .isPrimaryProfile(isPrimaryProfile)
                .build();
    }
}
