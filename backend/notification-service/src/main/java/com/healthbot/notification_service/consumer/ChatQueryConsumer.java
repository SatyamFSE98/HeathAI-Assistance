package com.healthbot.notification_service.consumer;

import com.healthbot.notification_service.dto.ChatQueryEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ChatQueryConsumer {

    @KafkaListener(
            topics = "${app.kafka.topic.chat-query}",
            groupId = "notification-group"
    )
    public void consume(ChatQueryEvent event) {

        System.out.println("=================================");
        System.out.println("New Chat Query Event Received");
        System.out.println("User Id  : " + event.getUserId());
        System.out.println("Question : " + event.getQuestion());
        System.out.println("Category : " + event.getCategory());
        System.out.println("Time     : " + event.getCreatedAt());
        System.out.println("=================================");
    }
}