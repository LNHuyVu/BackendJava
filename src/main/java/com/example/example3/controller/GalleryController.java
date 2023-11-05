package com.example.example3.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.example3.entity.Gallery;
import com.example.example3.service.GalleryService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/gallery")
@CrossOrigin(origins = "http://localhost:3000")
public class GalleryController {
    private GalleryService galleryService;

    @PostMapping
    public ResponseEntity<Gallery> createGallery(@RequestBody Gallery gallery) {
        Gallery savedGallery = galleryService.createGallery(gallery);
        return new ResponseEntity<>(savedGallery, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Gallery> getGalleryById(@PathVariable("id") Long galleryId) {
        Gallery gallery = galleryService.getGalleryById(galleryId);
        return new ResponseEntity<>(gallery, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Gallery>> getAllGallerys() {
        List<Gallery> Gallerys = galleryService.getAllGallerys();
        return new ResponseEntity<>(Gallerys, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Gallery> updateGallery(@PathVariable("id") Long galleryId,
            @RequestBody Gallery Gallery) {
        Gallery.setId(galleryId);
        Gallery upGallery = galleryService.updateGallery(Gallery);
        return new ResponseEntity<>(upGallery, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteGallery(@PathVariable("id") Long galleryId) {
        galleryService.deleteGallery(galleryId);
        return new ResponseEntity<>("Gallery delete OK", HttpStatus.OK);
    }
}