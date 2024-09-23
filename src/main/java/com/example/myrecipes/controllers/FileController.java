package com.example.myrecipes.controllers;

import com.example.myrecipes.services.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @GetMapping("/download")
    public ResponseEntity<InputStreamResource> download() {
        InputStreamResource inputStreamResource = fileService.downloadDataFile();
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=my_file.jpg")
                .body(inputStreamResource);
    }
}
