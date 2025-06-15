package com.fc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories( //com.fc 패키지 하위대상 설정
    basePackages = "com.fc",
    mongoTemplateRef = MongoTemplateConfig.MONGO_TEMPLATE
)
public class MongoTemplateConfig {

    public static final String MONGO_TEMPLATE = "notificationMongoTemplate";

    @Bean(name = "notificationMongoTemplate")
    public MongoTemplate notificatioMongoTemplate(
        MongoDatabaseFactory notificationMongoFactory,
        MongoConverter mongoConverter
    ) {
        return new MongoTemplate(notificationMongoFactory, mongoConverter);
    }
}
