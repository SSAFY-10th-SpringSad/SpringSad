package com.spring.sad.member.repository;

import com.spring.sad.member.domain.MemberBand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberBandRepository extends JpaRepository<MemberBand, Long> {

    @Query("""
        SELECT MemberBand
        FROM MemberBand
        WHERE member.id = :memberId
        AND band.id = :bandId
        """)
    Optional<MemberBand> findByMember_IdAndBand_Id(
            @Param("memberId") final Long memberId,
            @Param("bandId") final Long bandId
    );

}
