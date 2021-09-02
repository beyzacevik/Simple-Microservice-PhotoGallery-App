package com.example.optiimsample.controller;

import com.example.optiimsample.model.Photo;
import com.example.optiimsample.repository.PhotoRepository;
import com.example.optiimsample.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Base64;

@RestController
public class PhotoController {

    private PhotoService photoService;

    @Autowired
    private PhotoRepository photoRepo;

    @PostConstruct
    public void init(){

        Photo photo = new Photo();
        photo.setTitle("benimfoto");
        photoRepo.save(photo);
    }

    @PostMapping("/photos/add")
    public String addPhoto(@RequestParam("title") String title, @RequestParam("image") MultipartFile image)
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
