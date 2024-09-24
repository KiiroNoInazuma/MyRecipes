package com.example.myrecipes.controllers;

import com.example.myrecipes.services.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @GetMapping("/download")
    public ResponseEntity<InputStreamResource> download() {
        InputStreamResource inputStreamResource = fileService.downloadDataFile();
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                //.header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=my_file.json")
                .body(inputStreamResource);
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> upload(@RequestParam MultipartFile multipartFile) {
        fileService.uploadDataFile(multipartFile);
        return ResponseEntity.ok().build();
    }
}
