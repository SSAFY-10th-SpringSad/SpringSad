package com.spring.sad.member.data.dto.request;

import com.spring.sad.member.data.dto.common.MemberProfileBody;
import com.spring.sad.member.data.dto.common.MemberProfileDetails;
import com.spring.sad.member.domain.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MemberProfileRequest extends MemberProfileBody {

    public static MemberProfileRequest toRequest(Member member) {
        return new MemberProfileRequest(member.getId(), member.getProfiles().stream()
                .map(MemberProfileDetails::from)
                .toList());
    }

    private MemberProfileRequest(long memberId, List<MemberProfileDetails> memberProfileDetailsList) {
        this.memberId = memberId;
        this.memberProfileDetailsList = memberProfileDetailsList;
    }
}