package com.healthbot.chat_service.service;


import com.healthbot.chat_service.document.ChatMessage;
import com.healthbot.chat_service.dto.AskQuestionRequest;
import com.healthbot.chat_service.dto.ChatQueryEvent;
import com.healthbot.chat_service.dto.ChatResponse;
import com.healthbot.chat_service.repository.ChatRepository;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatService {
    private final GeminiService geminiService;
    private final ChatRepository chatRepository;
    private final ChatEventProducer chatEventProducer;


    public ChatService(GeminiService geminiService, ChatRepository chatRepository, ChatEventProducer chatEventProducer) {
        this.geminiService = geminiService;
        this.chatRepository = chatRepository;
        this.chatEventProducer = chatEventProducer;
    }

    public ChatResponse askQuestion(AskQuestionRequest request){
        String question = request.getQuestion().toLowerCase();

        String answer = geminiService.generateHealthAnswer(request.getQuestion());
        String category = detectCategory(request.getQuestion());

        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUserId(request.getUserId());
        chatMessage.setQuestion(request.getQuestion());
        chatMessage.setAnswer(answer);
        chatMessage.setCategory(category);
        chatMessage.setCreatedAt(LocalDateTime.now());

        ChatMessage saved = chatRepository.save(chatMessage);

        ChatQueryEvent event = new ChatQueryEvent(
                saved.getUserId(),
                saved.getQuestion(),
                saved.getCategory(),
                saved.getCreatedAt()
        );

        chatEventProducer.sendChatQueryEvent(event);


        return  mapToResponse(saved);

    }

    public List<ChatResponse> getChatHistory(Long userId) {
        return chatRepository.findByUserIdOrderByCreatedAtDesc(userId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private ChatResponse mapToResponse(ChatMessage message) {
        return new ChatResponse(
                message.getId(),
                message.getUserId(),
                message.getQuestion(),
                message.getAnswer(),
                message.getCategory(),
                message.getCreatedAt()
        );
    }

    private String detectCategory(String question) {
        String q = question.toLowerCase();

        if (q.contains("fever") || q.contains("temperature")) {
            return "FEVER";
        } else if (q.contains("cold") || q.contains("cough")) {
            return "COLD_COUGH";
        } else if (q.contains("headache") || q.contains("migraine")) {
            return "HEADACHE";
        } else if (q.contains("stomach") || q.contains("gas") || q.contains("acidity")) {
            return "DIGESTION";
        } else if (q.contains("liver") || q.contains("fatty liver")) {
            return "LIVER";
        } else if (q.contains("sleep") || q.contains("snoring")) {
            return "SLEEP";
        }

        return "GENERAL_HEALTH";
    }

    public void deleteChatHistory(Long userId) {
        chatRepository.deleteByUserId(userId);
    }
}
