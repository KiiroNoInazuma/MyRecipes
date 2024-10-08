package com.example.myrecipes.services.impl;

import com.example.myrecipes.models.Recipe;
import com.example.myrecipes.services.FileService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Path;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final ObjectMapper mapper;

    @Value("${my.custom.path-file}")
    private String pathFile;

    @Value("${my.custom.name-file}")
    private String nameFile;

    @Override
    public Path getPath() {
        return Path.of(pathFile, nameFile);
    }

    @SneakyThrows
    @Override
    public InputStreamResource downloadDataFile() {
        File file = new File(getPath().toString());
        return new InputStreamResource(new FileInputStream(file));
    }

    @SneakyThrows
    @Override
    public void uploadDataFile(MultipartFile multipartFile) {
        File file = new File(getPath().toString());
        try (BufferedInputStream bis = new BufferedInputStream(multipartFile.getInputStream());
             FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(bis.readAllBytes());
        }
    }

    @Override
    public void saveFile(Map<Integer, Recipe> json) {
        try (FileWriter fileWriter = new FileWriter(getPath().toString())) {
            fileWriter.write(convertJsonToString(json));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String convertJsonToString(Map<Integer, Recipe> map) throws JsonProcessingException {
        return mapper.writeValueAsString(map);
    }

    private Map<Integer, Recipe> convertStringToMap(String json) throws JsonProcessingException {
        return mapper.readValue(json, new TypeReference<>() {
        });
    }

    @SneakyThrows
    @Override
    public Map<Integer, Recipe> readAndWriteContent() {
        String s = readFile(getPath().toString());
        return convertStringToMap(s);
    }


    private String readFile(String path) {
        try (FileReader fileReader = new FileReader(path);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
