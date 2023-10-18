package com.spring.sad.notification.domain;

import com.spring.sad.BaseTimeEntity;
import com.spring.sad.member.domain.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notification extends BaseTimeEntity {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int notificationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(nullable = false)
    private String context;

    private boolean isRead;

    private String referenceId;

    @Builder
    public Notification(int notificationId, Member member, String context, boolean isRead, String referenceId){
        this.notificationId = notificationId;
        this.member = member;
        this.context = context;
        this.isRead = isRead;
        this.referenceId = referenceId;
    }
}