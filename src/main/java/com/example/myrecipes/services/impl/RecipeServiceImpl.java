package com.example.myrecipes.services.impl;

import com.example.myrecipes.models.Recipe;
import com.example.myrecipes.services.FileService;
import com.example.myrecipes.services.RecipeService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

import static com.example.myrecipes.services.impl.IngredientServiceImpl.ingredients;

@Service
@Slf4j
public class RecipeServiceImpl implements RecipeService {

    private int countId;

    private int skip;

    public static Map<Integer, Recipe> repositoryRecipe;

    private final FileService fileService;


    public RecipeServiceImpl(FileService fileService) {
        this.fileService = fileService;
        repositoryRecipe = new HashMap<>();
    }

    @PostConstruct
    public void init() {
        try {
            if (Files.exists(fileService.getPath()) && Files.size(fileService.getPath()) != 0) {
                repositoryRecipe = fileService.readAndWriteContent();
                countId = repositoryRecipe.size();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addRecipe(Recipe recipe) {
        recipe.setIngredients(ingredients);
        repositoryRecipe.put(++countId, recipe);
        fileService.saveFile(repositoryRecipe);
    }

    @Override
    public Recipe getRecipe(Integer recipeId) {
        return repositoryRecipe.get(recipeId);
    }

    @Override
    public List<Recipe> listTenRecipes() {
        List<Recipe> list = repositoryRecipe.values().stream().skip(skip).limit(skip + 10).toList();
        skip += 10;
        return list;
    }
}
