package com.example.example3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.example3.entity.Feedback;

public interface FeedbackRespository extends JpaRepository<Feedback, Long> {

}