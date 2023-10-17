package com.spring.sad.member.domain;

import com.spring.sad.comment.domain.Comment;
import com.spring.sad.global.domain.BaseEntity;
import com.spring.sad.member.domain.enums.GenderEnum;
import com.spring.sad.notification.domain.Notification;
import com.spring.sad.post.domain.Post;
import com.spring.sad.profile.domain.Profile;
import jakarta.persistence.*;
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
    private String name;

    @Column(nullable = false)
    private String password;

    private String email;

    private String cellPhone;

    @Enumerated(EnumType.STRING)
    private GenderEnum genderEnum;

    private LocalDate birthDay;

    private boolean isDeleted;

    @OneToMany(mappedBy = "member")
    private List<Profile> profileList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Notification> notificationList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Post> postList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Comment> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
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
