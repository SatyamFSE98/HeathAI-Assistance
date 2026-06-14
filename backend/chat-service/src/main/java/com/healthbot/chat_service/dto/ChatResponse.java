package com.healthbot.chat_service.dto;

import java.time.LocalDateTime;

public class ChatResponse {

    private String id;
    private Long userId;
    private String question;
    private String answer;
    private String category;
    private LocalDateTime createdAt;

    public ChatResponse() {
    }

    public ChatResponse(String id, Long userId, String question, String answer, String category, LocalDateTime createdAt) {
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
}