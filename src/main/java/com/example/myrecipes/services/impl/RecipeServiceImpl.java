package com.example.myrecipes.services.impl;

import com.example.myrecipes.models.Ingredient;
import com.example.myrecipes.models.Recipe;
import com.example.myrecipes.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class RecipeServiceImpl implements RecipeService {
    private int countId;
    private final static Map<Integer, Recipe> REPOSITORY_RECIPE = new HashMap<>();
    private final static List<Ingredient> ingredients = new ArrayList<>();

    @Override
    public void addRecipe(Recipe recipe) {
        recipe.setIngredients(ingredients);
        REPOSITORY_RECIPE.put(++countId, recipe);

    }

    @Override
    public Recipe getRecipe(Integer recipeId) {
        return REPOSITORY_RECIPE.get(recipeId);
    }

    @Override
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    @Override
    public Ingredient getIngredient(Integer recipeId, Integer ingredientId) {
        return REPOSITORY_RECIPE.get(recipeId).getIngredients().get(ingredientId - 1);
    }
}
