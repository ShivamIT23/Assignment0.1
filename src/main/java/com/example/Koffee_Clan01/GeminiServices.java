package com.example.Koffee_Clan01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeminiServices {

    @Value("${Gemini_Key}")
    private String apiKey;

    private final String GEMINI_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent";

    public String generateSummary(String content) {
        RestTemplate restTemplate = new RestTemplate();
        
        // Build the request object
        GeminiRequest request = new GeminiRequest(content);
        
        // Setup headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        // Create HTTP entity with request body and headers
        HttpEntity<GeminiRequest> entity = new HttpEntity<>(request, headers);
        String urlWithKey = GEMINI_URL + "?key=" + apiKey;
        
        try {
            // Send request and receive response
            GeminiResponse response = restTemplate.postForObject(urlWithKey, entity, GeminiResponse.class);
            System.out.println("skdbs1");
            
            // Extract the summarized content
            if (response != null && response.getCandidates() != null && !response.getCandidates().isEmpty()) {
                System.out.println("skdbs1");
                return response.getCandidates().get(0).getContent().getParts().get(0).getText();
            }
            System.out.println("skdbs1");
            return "No summary generated.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to generate summary.";
        }
    }
}

