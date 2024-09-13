package com.example.myrecipes.services;

import com.example.myrecipes.models.Recipe;

import java.util.List;

public interface RecipeService {
    void addRecipe(Recipe recipe);

    Recipe getRecipe(Integer recipeId);

    List<Recipe> listTenRecipes();
}
