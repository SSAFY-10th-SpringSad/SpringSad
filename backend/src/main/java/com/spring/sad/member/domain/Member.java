package com.spring.sad.member.domain;

import com.spring.sad.BaseTimeEntity;
import com.spring.sad.profile.domain.Profile;
import jakarta.persistence.*;
import jakarta.validation.constraints.Null;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name="member")
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

    private String email;

    private String cellPhone;

    private String gender;

    private String birthday;

    private boolean isDeleted;

    @OneToMany(mappedBy = "member")
    private List<Profile> profiles = new ArrayList<>();
}