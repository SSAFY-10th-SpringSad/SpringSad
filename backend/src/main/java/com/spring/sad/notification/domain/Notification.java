package com.spring.sad.notification.domain;

import com.spring.sad.member.domain.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long notificationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String content;

    private Boolean isRead;

    private String referenceUrl;

    public Notification(Member member, String content, String referenceUrl) {
        addRelateMember(member);
        this.content = content;
        this.referenceUrl = referenceUrl;
    }

    private void addRelateMember(Member member) {
        this.member = member;
        member.getNotifications().add(this);
    }
}
