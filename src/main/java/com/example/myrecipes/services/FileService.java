package com.example.myrecipes.services;

import com.example.myrecipes.models.Recipe;
import org.springframework.core.io.InputStreamResource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.Map;

public interface FileService {

    Path getPath();

    InputStreamResource downloadDataFile();

    void uploadDataFile(MultipartFile multipartFile);

    void saveFile(Map<Integer, Recipe> json);
    Map<Integer, Recipe> readAndWriteContent();
}
