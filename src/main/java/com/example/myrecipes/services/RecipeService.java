package com.example.myrecipes.services;

import com.example.myrecipes.models.Recipe;

public interface RecipeService {
    void addRecipe(Recipe recipe);

    Recipe getRecipe(Integer recipeId);
}
