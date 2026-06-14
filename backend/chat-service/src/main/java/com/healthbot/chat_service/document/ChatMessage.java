package com.healthbot.chat_service.document;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "chat-messages")
public class ChatMessage {


    @Id
    private String id;

    private Long userId;
    private String question;
    private String answer;
    private String category;
    private LocalDateTime createdAt;

    public ChatMessage() {
    }

    public ChatMessage(String id, Long userId, String question, String answer, String category, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.question = question;
        this.answer = answer;
        this.category = category;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getCategory() {
        return category;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
