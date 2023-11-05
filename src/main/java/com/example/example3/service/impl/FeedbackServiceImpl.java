package com.example.example3.service.impl;

import java.util.List;

import com.example.example3.entity.Feedback;
import com.example.example3.repository.FeedbackRespository;
import com.example.example3.service.FeedbackService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {
    private FeedbackRespository feedbackRespository;

    @Override
    public Feedback createFeedback(Feedback feedback) {
        return feedbackRespository.save(feedback);
    }

    @Override
    public Feedback getFeedbackById(Long feedbackId) {
        Optional<Feedback> optionalFeedback = feedbackRespository.findById(feedbackId);
        return optionalFeedback.get();
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbackRespository.findAll();
    }

    @Override
    public Feedback updateFeedback(Feedback feedback) {
        Feedback existingFeedback = feedbackRespository.findById(feedback.getId()).get();
        existingFeedback.setFirstname(feedback.getFirstname());
        existingFeedback.setFirstname(feedback.getFirstname());
        existingFeedback.setEmail(feedback.getEmail());
        existingFeedback.setPhone_number(feedback.getPhone_number());
        existingFeedback.setSubject_name(feedback.getSubject_name());
        existingFeedback.setNote(feedback.getNote());
        existingFeedback.setStatus(feedback.getStatus());
        existingFeedback.setCreated_at(feedback.getCreated_at());
        existingFeedback.setUpdated_at(feedback.getUpdated_at());

        Feedback updatedFeedback = feedbackRespository.save(existingFeedback);
        return updatedFeedback;
    }

    @Override
    public void deleteFeedback(Long feedbackId) {
        feedbackRespository.deleteById(feedbackId);
    }
}
