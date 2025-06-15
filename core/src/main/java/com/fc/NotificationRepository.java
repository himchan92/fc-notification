package com.fc;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends MongoRepository<Notification, String> {
    Optional<Notification> findById(String id); //아이디 찾기(없는경우 대비 Optional)

    Notification save(Notification notification); //저장

    void deleteById(String id); //삭제
}
