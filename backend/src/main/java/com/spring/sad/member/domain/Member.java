package com.spring.sad.member.domain;

import com.spring.sad.global.domain.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private long id;
    private String memberName;
    private String memberPassword;

    @Email
    private String memberEmail;

    private String memberCellPhone;

    @Enumerated(EnumType.STRING)
    private Gender memberGender;

    private String memberBirthday;

    private String memberRegDate;

    private String memberModDate;

    private Boolean memberDeleted;

    @Builder
    public Member(
            String memberName,
            String memberPassword,
            String memberEmail,
            String memberCellPhone,
            Gender memberGender,
            String memberBirthday) {
        this.memberName = memberName;
        this.memberPassword = memberPassword;
        this.memberEmail = memberEmail;
        this.memberCellPhone = memberCellPhone;
        this.memberGender = memberGender;
        this.memberBirthday = memberBirthday;
    }
}
