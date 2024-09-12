package com.example.myrecipes.services;

import com.example.myrecipes.models.Ingredient;

import java.util.List;

public interface IngredientService {
    void addIngredient(Ingredient ingredient);

    Ingredient editIngredient(int id, Ingredient ingredient);

    void removeIngredient(int id);

    Ingredient getIngredient(Integer recipeId, Integer ingredientId);

    List<Ingredient> getAllIngredient();
}
