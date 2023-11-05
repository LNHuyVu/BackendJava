package com.example.example3.service;

import java.util.List;

import com.example.example3.entity.Gallery;

public interface GalleryService {

    public Gallery createGallery(Gallery gallery);

    public Gallery getGalleryById(Long galleryId);

    public List<Gallery> getAllGallerys();

    public Gallery updateGallery(Gallery gallery);

    public void deleteGallery(Long galleryId);
}