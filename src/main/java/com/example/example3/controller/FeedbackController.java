package com.example.example3.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.example3.entity.Feedback;
import com.example.example3.service.FeedbackService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/feedback")
@CrossOrigin(origins = "http://localhost:3000")
public class FeedbackController {
    private FeedbackService feedbackService;

    @PostMapping
    public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback feedback) {
        Feedback savedFeedback = feedbackService.createFeedback(feedback);
        return new ResponseEntity<>(savedFeedback, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable("id") Long feedbackId) {
        Feedback feedback = feedbackService.getFeedbackById(feedbackId);
        return new ResponseEntity<>(feedback, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedbacks() {
        List<Feedback> Feedbacks = feedbackService.getAllFeedbacks();
        return new ResponseEntity<>(Feedbacks, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable("id") Long feedbackId,
            @RequestBody Feedback Feedback) {
        Feedback.setId(feedbackId);
        Feedback upFeedback = feedbackService.updateFeedback(Feedback);
        return new ResponseEntity<>(upFeedback, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFeedback(@PathVariable("id") Long feedbackId) {
        feedbackService.deleteFeedback(feedbackId);
        return new ResponseEntity<>("Feedback delete OK", HttpStatus.OK);
    }
}