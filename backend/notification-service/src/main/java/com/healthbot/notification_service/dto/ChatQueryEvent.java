package com.healthbot.notification_service.dto;

import java.time.LocalDateTime;

public class ChatQueryEvent {

    private Long userId;
    private String question;
    private String category;
    private LocalDateTime createdAt;

    public ChatQueryEvent() {
    }

    public Long getUserId() {
        return userId;
    }

    public String getQuestion() {
        return question;
    }

    public String getCategory() {
        return category;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}