package com.example.example3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.example3.entity.Gallery;

public interface GalleryRespository extends JpaRepository<Gallery, Long> {

}