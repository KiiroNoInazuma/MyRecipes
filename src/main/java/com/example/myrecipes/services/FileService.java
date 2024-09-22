package com.example.myrecipes.services;

import com.example.myrecipes.models.Recipe;

import java.util.Map;

public interface FileService {

    void saveFile(Map<Integer, Recipe> json);
    Map<Integer, Recipe> readAndWriteContent();
}
