package com.spring.sad.member.data.dto.response;

import com.spring.sad.member.data.dto.common.ProfileListDetails;
import com.spring.sad.member.data.dto.common.ProfileDetails;
import com.spring.sad.member.domain.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ProfileListResponse extends ProfileListDetails {

    public static ProfileListResponse toResponse(Member member) {
        return new ProfileListResponse(member.getId(), member.getProfiles().stream()
                .map(ProfileDetails::from)
                .toList());
    }

    private ProfileListResponse(long memberId, List<ProfileDetails> profileDetailsList) {
        this.memberId = memberId;
        this.profileDetailsList = profileDetailsList;
    }
}