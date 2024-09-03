package com.example.myrecipes.services;

import com.example.myrecipes.models.Ingredient;
import com.example.myrecipes.models.Recipe;

public interface RecipeService {
    void addRecipe(Recipe recipe);
    Recipe getRecipe(Integer recipeId);

    void addIngredient(Ingredient ingredient);
    Ingredient getIngredient(Integer recipeId ,Integer ingredientId);
}
