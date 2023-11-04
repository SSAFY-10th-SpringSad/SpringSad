package com.spring.sad.member.data.dto.request;

import com.spring.sad.member.data.dto.common.ProfileListDetails;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ProfileUpdateRequest extends ProfileListDetails {
}