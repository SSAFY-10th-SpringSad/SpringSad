package com.spring.sad.notification.domain;

import com.spring.sad.member.domain.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @Column(nullable = false)
    private String content;

    private boolean isRead;

    private String referenceId;

    @Builder
    public Notification(
            String content,
            boolean isRead,
            String referenceId,
            Member member) {
        this.content = content;
        this.isRead = isRead;
        this.referenceId = referenceId;
        addRelatedMember(member);
    }

    private void addRelatedMember(Member member) {
        this.member = member;
        member.getNotificationList().add(this);
    }

}
