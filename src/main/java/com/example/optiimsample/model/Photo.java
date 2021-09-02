package com.example.optiimsample.model;

import lombok.*;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document(collection = "photos")
@AllArgsConstructor
@NoArgsConstructor

@RequiredArgsConstructor
@Setter
@Getter
public class Photo {
    @Id
    private String id;
    @NonNull
    private String title;
    private Binary image;

}
