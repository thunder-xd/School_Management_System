package com.example.frontend.teacherreview.Controller;

import com.example.frontend.teacherreview.Service.GeminiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gemini")
public class GeminiController {

    private final GeminiService geminiService;

    public GeminiController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @GetMapping("/feedback-score")
    public String getFeedbackScore(@RequestParam String newFeedback,
                                   @RequestParam String oldFeedback,
                                   @RequestParam double prevScore,
                                   @RequestParam int ppl) {
        return geminiService.getOutput(newFeedback, oldFeedback, prevScore, ppl);
    }
}
