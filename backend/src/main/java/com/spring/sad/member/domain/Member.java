package com.spring.sad.member.domain;

import com.spring.sad.comment.domain.Comment;
import com.spring.sad.global.domain.BaseEntity;
import com.spring.sad.member.domain.enums.GenderEnum;
import com.spring.sad.notification.domain.Notification;
import com.spring.sad.post.domain.Post;
import com.spring.sad.profile.domain.Profile;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private int id;

    @Column(nullable = false)
    @NotBlank
    private String name;

    @Column(nullable = false)
    @NotBlank
    private String password;

    @NotBlank
    private String email;

    @NotBlank
    private String cellPhone;

    @Enumerated(EnumType.STRING)
    private GenderEnum genderEnum;

    private LocalDate birthDay;

    private boolean isDeleted;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Profile> profileList = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Notification> notificationList = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Post> postList = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Comment> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<MemberBand> memberBandList = new ArrayList<>();

    @Builder public Member(
            String name,
            String password,
            String email,
            String cellPhone,
            GenderEnum genderEnum,
            LocalDate birthDay,
            boolean isDeleted) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.cellPhone = cellPhone;
        this.genderEnum = genderEnum;
        this.birthDay = birthDay;
        this.isDeleted = isDeleted;
    }

}
