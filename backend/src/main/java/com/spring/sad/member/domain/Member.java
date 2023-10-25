package com.spring.sad.member.domain;

import com.spring.sad.global.domain.BaseEntity;
import com.spring.sad.member.domain.embbeded.PhoneNumber;
import com.spring.sad.member.domain.embbeded.Email;
import com.spring.sad.notification.domain.Notification;
import com.spring.sad.post.domain.Comment;
import com.spring.sad.post.domain.Post;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memberId;

    private String name;

    private String password;

    @Embedded
    private Email email;

    @Embedded
    private PhoneNumber phoneNumber;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate birthdate;

    private Boolean isDeleted;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Profile> profiles = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<MemberBand> memberBands = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Notification> notifications = new ArrayList<>();

    @Builder
    public Member(String name,
                  String password,
                  Email email,
                  PhoneNumber phoneNumber,
                  Gender gender,
                  LocalDate birthDate) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.birthdate = birthDate;
    }
}
