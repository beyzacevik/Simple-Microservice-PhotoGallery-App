package com.example.optiimsample.controller;

import com.example.optiimsample.model.Photo;
import com.example.optiimsample.repository.PhotoRepository;
import com.example.optiimsample.service.PhotoService;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Optional;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PhotoController.class)

class PhotoControllerTest {

    private final static String CONTENT_TYPE = "multipart/mixed";

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PhotoService photoService;
    @MockBean
    private PhotoRepository photoRepository;

    @Test
    public void whenPhotoAdded_thenVerifyStatus()
            throws Exception {
        MockMultipartFile file
                = new MockMultipartFile(
                "image",
                "/Users/beyzacevik/Downloads/beyza-cevik-pset3/q1.jpeg",
                MediaType.IMAGE_JPEG_VALUE,
                "image".getBytes()
        );

        mockMvc.perform(multipart("/photos/add").file(file).param("title", "test-title"))
                .andExpect(status().isOk());
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    void whenCallGetPhoto_thenReturns200() throws Exception {

        Binary binary_test_img =  new Binary(BsonBinarySubType.BINARY, "testing binary".getBytes());
        Photo photo = new Photo("idTest", "title", binary_test_img);
        when(photoRepository.findById("idTest")).thenReturn(Optional.of(photo));

    }

}