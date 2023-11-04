package com.spring.sad.member.data.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class ProfileListDetails {
    protected long memberId;
    @JsonProperty("profiles")
    protected List<ProfileDetails> profileDetailsList = new ArrayList<>();
}

