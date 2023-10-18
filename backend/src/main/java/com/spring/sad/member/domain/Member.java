package com.spring.sad.member.domain;

import com.spring.sad.BaseTimeEntity;
import com.spring.sad.band.domain.Band;
import com.spring.sad.band.domain.MemberBand;
import com.spring.sad.comment.domain.Comment;
import com.spring.sad.member.enums.GenderEnum;
import com.spring.sad.notification.domain.Notification;
import com.spring.sad.post.domain.Post;
import com.spring.sad.profile.domain.Profile;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Null;
import lombok.*;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Email
    private String email;

    private String cellPhone;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    private String birthday;

    private boolean isDeleted;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Profile> profiles = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Notification> notifications = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Band> bands = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<MemberBand> memberBands = new ArrayList<>();

    @Builder
    public Member(int id, String name, String password, String email, String cellPhone, GenderEnum gender, String birthday, boolean isDeleted){
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.cellPhone = cellPhone;
        this.gender = gender;
        this.birthday = birthday;
        this.isDeleted = isDeleted;
    }
}