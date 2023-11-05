package com.example.example3.service.impl;

import java.util.List;

import com.example.example3.entity.Gallery;
import com.example.example3.repository.GalleryRespository;
import com.example.example3.service.GalleryService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GalleryServiceImpl implements GalleryService {
    private GalleryRespository galleryRespository;

    @Override
    public Gallery createGallery(Gallery gallery) {
        return galleryRespository.save(gallery);
    }

    @Override
    public Gallery getGalleryById(Long galleryId) {
        Optional<Gallery> optionalGallery = galleryRespository.findById(galleryId);
        return optionalGallery.get();
    }

    @Override
    public List<Gallery> getAllGallerys() {
        return galleryRespository.findAll();
    }

    @Override
    public Gallery updateGallery(Gallery gallery) {
        Gallery existingGallery = galleryRespository.findById(gallery.getId()).get();
        existingGallery.setThumbnail(gallery.getThumbnail());
        Gallery updatedGallery = galleryRespository.save(existingGallery);
        return updatedGallery;
    }

    @Override
    public void deleteGallery(Long galleryId) {
        galleryRespository.deleteById(galleryId);
    }
}
