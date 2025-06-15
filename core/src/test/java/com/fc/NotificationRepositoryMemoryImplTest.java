package com.fc;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootApplication
@SpringBootTest
class NotificationRepositoryMemoryImplTest {

    @Autowired
    private NotificationRepository sut;

    private final Long userId = 2L;
    private final Instant now = Instant.now();
    private final Instant ninetyDaysAfter = Instant.now().plus(90, ChronoUnit.DAYS); //90일 지나면 삭제대상

    @Test
    void test_save() {
        //알림 객체 생성
        //저장
        //조회 시 객체존재유무 체크
        sut.save(new Notification("1", userId, NotificationType.LIKE, now, ninetyDaysAfter));
        Optional<Notification> notification = sut.findById("1");

        assertTrue(notification.isPresent());
    }

    @Test
    void test_find_by_id() {
        String id = "2";

        sut.save(new Notification(id, userId, NotificationType.LIKE, now, ninetyDaysAfter));
        Optional<Notification> optionalNotification = sut.findById(id);

        Notification notification = optionalNotification.orElseThrow();
        assertEquals(notification.id, id);
        assertEquals(notification.userId, userId);

        //getEpochSecond : 초단위는 자르기
        assertEquals(notification.createdAt.getEpochSecond(), now.getEpochSecond());
        assertEquals(notification.deletedAt.getEpochSecond(), ninetyDaysAfter.getEpochSecond());
    }

    @Test
    public void test_delete_by_id() {
        String id = "3";

        sut.save(new Notification(id, userId, NotificationType.LIKE, now, ninetyDaysAfter));
        sut.deleteById(id);

        Optional<Notification> optionalNotification = sut.findById(id);
        assertFalse(optionalNotification.isPresent());
    }
}