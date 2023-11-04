package com.spring.sad.member.data.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class MemberProfileBody {
    protected long memberId;
    @JsonProperty("profiles")
    protected List<MemberProfileDetails> memberProfileDetailsList = new ArrayList<>();
}

