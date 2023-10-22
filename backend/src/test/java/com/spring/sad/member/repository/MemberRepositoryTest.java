package com.spring.sad.member.repository;

import com.spring.sad.member.domain.Member;
import com.spring.sad.member.domain.embedded.Email;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("멤버 생성")
    void createMember() {
        // given
        Member member = Member.builder().
                        email(Email.from("lkt9899@naver.com")).
                        password("1234").
                        build();

        // when
        Member result = memberRepository.save(member);

        // then
        Assertions.assertThat(member.getEmail()).isEqualTo(result.getEmail());
        assertEquals(member.getEmail(), result.getEmail());
    }
}