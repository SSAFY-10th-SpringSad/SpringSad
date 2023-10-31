package com.spring.sad.member.data.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.sad.member.domain.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ProfileSettingResponse {
    private long memberId;
    @JsonProperty("profiles")
    private List<MemberProfileDetails> memberProfileDetailsList = new ArrayList<>();

    private ProfileSettingResponse(long memberId) {
        this.memberId = memberId;
    }
    public static ProfileSettingResponse toResponse(Member member) {
        ProfileSettingResponse response = new ProfileSettingResponse(member.getMemberId());
        member.getProfiles().stream()
                .map(MemberProfileDetails::from)
                .forEach(response.memberProfileDetailsList::add);
        return response;
    }
}

