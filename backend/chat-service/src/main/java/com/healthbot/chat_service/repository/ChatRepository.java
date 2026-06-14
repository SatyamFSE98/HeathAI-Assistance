package com.healthbot.chat_service.repository;

import com.healthbot.chat_service.document.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends MongoRepository<ChatMessage,String> {
    List<ChatMessage> findByUserIdOrderByCreatedAtDesc(Long userId);

    void deleteByUserId(Long userId);

}
