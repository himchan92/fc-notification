package com.fc;

import java.util.Optional;

public interface NotificationRepository {
    Optional<Notification> findById(String id); //아이디 찾기(없는경우 대비 Optional)

    Notification save(Notification notification); //저장

    Notification deleteById(String id); //삭제
}
