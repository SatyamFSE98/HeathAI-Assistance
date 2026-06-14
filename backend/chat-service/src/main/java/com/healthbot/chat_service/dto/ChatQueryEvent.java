package com.healthbot.chat_service.dto;


import java.time.LocalDateTime;

public class ChatQueryEvent {

    private Long userId;
    private String question;
    private String category;
    private LocalDateTime createdAt;

    public ChatQueryEvent() {
    }

    public ChatQueryEvent(Long userId, String question, String category, LocalDateTime createdAt) {
        this.userId = userId;
        this.question = question;
        this.category = category;
        this.createdAt = createdAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
