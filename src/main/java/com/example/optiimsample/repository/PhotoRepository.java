package com.example.optiimsample.repository;

import com.example.optiimsample.model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhotoRepository extends MongoRepository<Photo, String> {



}
