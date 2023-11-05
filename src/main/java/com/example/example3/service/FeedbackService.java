package com.example.example3.service;

import java.util.List;

import com.example.example3.entity.Feedback;

public interface FeedbackService {

    public Feedback createFeedback(Feedback feedback);

    public Feedback getFeedbackById(Long feedbackId);

    public List<Feedback> getAllFeedbacks();

    public Feedback updateFeedback(Feedback feedback);

    public void deleteFeedback(Long feedbackId);
}