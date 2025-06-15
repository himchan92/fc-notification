package com.fc;

import java.time.Instant;

enum NotificationType {
    LIKE, //좋아요알림
    COMMENT, //댓글알림
    FOLLOW, //팔로우알림
}

public class Notification {
    public String id; //알림 저장 생성 ID
    public Long userId;
    public NotificationType notificationType;
    public Instant createdAt;
    public Instant deletedAt;

    public Notification(String id, Long userId, NotificationType notificationType, Instant createdAt, Instant deletedAt) {
        this.id = id;
        this.userId = userId;
        this.notificationType = notificationType;
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
    }
}
