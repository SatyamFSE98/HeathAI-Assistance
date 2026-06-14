package com.healthbot.chat_service.service;


import com.healthbot.chat_service.dto.ChatQueryEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ChatEventProducer {

    private final KafkaTemplate<String, ChatQueryEvent> kafkaTemplate;

    public ChatEventProducer(KafkaTemplate<String, ChatQueryEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Value("${app.kafka.topic.chat-query:chat-query-events}")
    private String chatQueryTopic;

    public void sendChatQueryEvent(ChatQueryEvent event){
        kafkaTemplate.send(chatQueryTopic,event);
    }

}
