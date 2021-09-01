package com.example.optiimsample.controller;

import com.example.optiimsample.model.Photo;
import com.example.optiimsample.service.PhotoService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

public class PhotoController {

    private PhotoService photoService;

    @PostMapping("/photos/add")
    public String addPhoto(@RequestParam("title") String title, @RequestParam("image") MultipartFile image, Model model)
        throws IOException{

            String id = photoService.addPhoto(title, image);
            return "redirect:/photos/" + id;
    }

    @GetMapping("/photos/{id}")
    public String getPhoto(@PathVariable String id, Model model)
        throws IOException{

            Photo photo = photoService.getPhoto(id);
            model.addAttribute("title", photo.getTitle());
            model.addAttribute("image", Base64.getEncoder().encodeToString(photo.getImage().getData()));
            return "photos";

    }
}
