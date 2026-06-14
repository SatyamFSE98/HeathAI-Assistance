package com.healthbot.chat_service.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class GeminiService {

    private final RestTemplate restTemplate;

    @Value("${gemini.api.key}")
    private String apiKey;

    @Value("${gemini.api.url}")
    private String apiUrl;

    public GeminiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String generateHealthAnswer(String userQuestion) {

        String prompt = """
                You are a helpful health assistant.
                Give simple general health guidance.
                Do not give final diagnosis.
                Always suggest consulting a qualified doctor for serious symptoms.
                Keep answer short and easy to understand.

                User question: %s
                """.formatted(userQuestion);

        Map<String, Object> requestBody = Map.of(
                "contents", List.of(
                        Map.of(
                                "parts", List.of(
                                        Map.of("text", prompt)
                                )
                        )
                )
        );

        String url = apiUrl + "?key=" + apiKey;

        Map response;

        try {
            response = restTemplate.postForObject(url, requestBody, Map.class);
        } catch (Exception e) {
            return "AI service is currently unavailable. Please try again later. For serious symptoms, consult a qualified doctor.";
        }

        try {
            List candidates = (List) response.get("candidates");
            Map firstCandidate = (Map) candidates.get(0);
            Map content = (Map) firstCandidate.get("content");
            List parts = (List) content.get("parts");
            Map firstPart = (Map) parts.get(0);

            return firstPart.get("text").toString();

        } catch (Exception e) {
            return "I am unable to generate an answer right now. Please try again later. For serious symptoms, consult a doctor.";
        }
    }
}