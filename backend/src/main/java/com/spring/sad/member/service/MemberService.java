package com.spring.sad.member.service;

import com.spring.sad.member.data.dto.common.ProfileDetails;
import com.spring.sad.member.data.dto.common.BandDetails;
import com.spring.sad.member.data.dto.request.*;
import com.spring.sad.member.data.dto.response.MemberLoginResponse;
import com.spring.sad.member.data.dto.response.ProfileListResponse;
import com.spring.sad.member.domain.Member;
import com.spring.sad.member.domain.MemberBand;
import com.spring.sad.member.domain.Profile;
import com.spring.sad.member.exception.MemberBandErrorCode;
import com.spring.sad.member.exception.MemberBandException;
import com.spring.sad.member.exception.MemberErrorCode;
import com.spring.sad.member.exception.MemberException;
import com.spring.sad.member.repository.MemberBandRepository;
import com.spring.sad.member.repository.MemberRepository;
import com.spring.sad.member.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberBandRepository memberBandRepository;
    private final ProfileRepository profileRepository;

    @Transactional
    public void signupByCellPhone(MemberSignupByPhoneNumberRequest request) {
        Member member = request.toMember();
        if (memberRepository.existsByPhoneNumber(member.getPhoneNumber())) {
            throw new MemberException(MemberErrorCode.PHONE_NUMBER_ALREADY_EXISTS);
        }
        memberRepository.save(member);
        makePrimaryProfile(member);
    }

    @Transactional
    public void signupByEmail(MemberSignupByEmailRequest request) {
        Member member = request.toMember();
        if (memberRepository.existsByEmail(member.getEmail())) {
            throw new MemberException(MemberErrorCode.EMAIL_ALREADY_EXISTS);
        }
        memberRepository.save(member);
        makePrimaryProfile(member);
    }

    private void makePrimaryProfile(Member member) {
        Profile profile = Profile.builder()
                .profileName(member.getName())
                .isPrimaryProfile(true)
                .build();
        member.getProfiles().add(profile);
    }

    public MemberLoginResponse loginByEmail(MemberLoginByEmailRequest request) {
        Member requestMember = request.toMember();
        Member member = memberRepository.findByEmail(requestMember.getEmail())
                .orElseThrow(()->
                        new MemberException(MemberErrorCode.LOGIN_FAILED));

        if(!requestMember.getPassword().equals(member.getPassword()))
            throw new MemberException(MemberErrorCode.LOGIN_FAILED);

        return MemberLoginResponse.toResponse(member);
    }

    public MemberLoginResponse loginByPhoneNumber(MemberLoginByPhoneNumberRequest request) {
        Member requestMember = request.toMember();
        Member member = memberRepository.findByPhoneNumber(requestMember.getPhoneNumber())
                .orElseThrow(()->
                        new MemberException(MemberErrorCode.LOGIN_FAILED));

        if(!requestMember.getPassword().equals(member.getPassword()))
            throw new MemberException(MemberErrorCode.LOGIN_FAILED);

        return MemberLoginResponse.toResponse(member);
    }

    public ProfileListResponse getProfileSetting(long memberId) {
        Member member = getMemberById(memberId);
        return ProfileListResponse.toResponse(member);
    }

    /**
     * 프로필을 업데이트하는 메소드
     * 1. (요청 값으로 받은) MemberId 유효성 확인
     * 2. (요청 값으로 받은) 프로필 리스트 순회
     * 2-1. 기존 프로필 삭제
     * 2-2. 새로운 프로필이 유효한 경우, 저장 및 연관관계 설정 진행
     *
     * @param request 요청으로 받은 정보 : 멤버의 프로필 리스트와, 각 프로필을 사용중인 밴드 리스트
     */
    public void updateProfile(ProfileUpdateRequest request) {
        Member member = getMemberById(request.getMemberId());

        for (ProfileDetails profileDetails : request.getProfileDetailsList()) {
            deleteExistingProfile(profileDetails);

            if (isValidProfileDetails(profileDetails)) {
                Profile profile = profileRepository.save(profileDetails.toProfile(member));
                updateMemberBand(request.getMemberId(), profileDetails.getBandDetailsList(), profile);
            }
        }
    }

    private void deleteExistingProfile(ProfileDetails profileDetails) {
        profileRepository.findById(profileDetails.getProfileId())
                .ifPresent(profileRepository::delete);
    }

    private Member getMemberById(long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberException(MemberErrorCode.MEMBER_DOES_NOT_EXISTS));
    }

    /**
     * 프로필이 유효한지 검증하는 메소드
     * 프로필이 유효한 경우란?
     *  1. 프로필이 대표 프로필인 경우
     *  2. 하나 이상의 밴드에서 사용되는 경우
     *
     * @param profileDetails (요청 값으로 받은) 프로필
     * @return (요청 값으로 받은) 프로필이 유효한지 검증한 결과
     */
    private boolean isValidProfileDetails(ProfileDetails profileDetails) {
        return !profileDetails.getBandDetailsList().isEmpty() || profileDetails.isPrimaryProfile();
    }

    /**
     * 밴드가 사용하는 프로필을 저장하는 메소드
     *
     * @param memberId 멤버 아이디
     * @param bandDetailsList (요청 값으로 받은) 밴드 리스트
     * @param profile 밴드가 사용할 프로필
     */
    private void updateMemberBand(Long memberId, List<BandDetails> bandDetailsList, Profile profile) {
        for (BandDetails bandDetails : bandDetailsList) {
            MemberBand memberBand = getMemberBand(memberId, bandDetails.getBandId());
            memberBand.changeProfile(profile);
        }
    }

    private MemberBand getMemberBand(Long memberId, Long bandId) {
        return memberBandRepository.findByMember_IdAndBand_Id(memberId, bandId)
                .orElseThrow(() -> new MemberBandException(MemberBandErrorCode.INVALID_MEMBER_BAND_RELATIONSHIP));
    }

}
