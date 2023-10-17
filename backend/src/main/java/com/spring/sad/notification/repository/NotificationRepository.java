package com.spring.sad.notification.repository;

import com.spring.sad.notification.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    Notification findNotificationByNotificationId(int notificationId);

    List<Notification> findNotificationByMemberId(int memberId);

    List<Notification> findNotificationByIsRead(boolean isRead);

    List<Notification> findNotificationByReferenceId(String referenceId);


}
