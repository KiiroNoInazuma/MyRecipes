package com.example.myrecipes.services;

import com.example.myrecipes.models.Ingredient;

public interface IngredientService {
    void addIngredient(Ingredient ingredient);

    Ingredient getIngredient(Integer recipeId, Integer ingredientId);
}
