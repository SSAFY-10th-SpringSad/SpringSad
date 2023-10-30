package com.spring.sad.member.repository;

import com.spring.sad.member.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    
}
