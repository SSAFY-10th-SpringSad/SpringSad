package com.spring.sad.member.domain;

import com.spring.sad.global.domain.BaseEntity;
import com.spring.sad.notification.domain.Notification;
import com.spring.sad.post.domain.Comment;
import com.spring.sad.post.domain.Post;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memberId;

    private String name;

    private String password;

    @Email
    private String email;

    private String cellPhone;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String birthday;

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
                  String email,
                  String cellPhone,
                  Gender gender,
                  String birthday) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.cellPhone = cellPhone;
        this.gender = gender;
        this.birthday = birthday;
    }
}
