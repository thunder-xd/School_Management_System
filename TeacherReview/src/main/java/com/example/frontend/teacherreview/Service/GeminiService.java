package com.example.frontend.teacherreview.Service;

import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class GeminiService {
    @Value("${GEMINI_API_KEY}")
    private String geminiApiKey;

    private final RestTemplate restTemplate;

    public GeminiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getOutput(String newFeedback, String oldFeedback, double prevScore, int ppl) {

        String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.0:generateContent?key={key}";

        Map<String,String> params = new HashMap<>();
        params.put("key", geminiApiKey);

        String prompt = "Please return a valid score with 2 decimal places out of 10 and a new feedback for the teacher where previously "+ppl+" people reviewed him/her as "+oldFeedback+". Now one person reported him as "+newFeedback;

        String requestBody = "{ \"prompt\": { \"text\": \"" + prompt + "\" } }";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class, params);
            return response.getBody();
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error retrieving Gemini response: " + e.getMessage();
        }
    }
}
