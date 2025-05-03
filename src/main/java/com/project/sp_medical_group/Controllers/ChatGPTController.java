package com.project.sp_medical_group.Controllers;

import com.project.sp_medical_group.Services.OpenAI.ChatGPTAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chatgpt")
public class ChatGPTController {
    private final ChatGPTAPIService chatGPTAPIService;

    @Autowired
    public ChatGPTController(ChatGPTAPIService chatGPTAPIService) {
        this.chatGPTAPIService = chatGPTAPIService;
    }

    @PostMapping
    public String chat(@RequestBody String message) {
        try {
            return chatGPTAPIService.chat(message);
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }
}
