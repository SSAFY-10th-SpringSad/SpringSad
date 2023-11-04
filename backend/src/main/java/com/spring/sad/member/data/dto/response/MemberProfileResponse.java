package com.spring.sad.member.data.dto.response;

import com.spring.sad.member.data.dto.common.MemberProfileBody;
import com.spring.sad.member.data.dto.common.MemberProfileDetails;
import com.spring.sad.member.domain.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MemberProfileResponse extends MemberProfileBody {

    public static MemberProfileResponse toResponse(Member member) {
        return new MemberProfileResponse(member.getId(), member.getProfiles().stream()
                .map(MemberProfileDetails::from)
                .toList());
    }

    private MemberProfileResponse(long memberId, List<MemberProfileDetails> memberProfileDetailsList) {
        this.memberId = memberId;
        this.memberProfileDetailsList = memberProfileDetailsList;
    }
}