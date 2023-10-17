package com.spring.sad.profile.repository;

import com.spring.sad.profile.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    Profile findProfileByProfileId(int profileId);

    List<Profile> findProfileByMemberId(int memberId);
}
