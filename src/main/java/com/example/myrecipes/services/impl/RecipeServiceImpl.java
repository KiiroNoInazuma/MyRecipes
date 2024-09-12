package com.example.myrecipes.services.impl;

import com.example.myrecipes.models.Ingredient;
import com.example.myrecipes.models.Recipe;
import com.example.myrecipes.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.example.myrecipes.services.impl.IngredientServiceImpl.ingredients;

@Service
@Slf4j
public class RecipeServiceImpl implements RecipeService {
    private int countId;
    public static final Map<Integer, Recipe> repositoryRecipe = new HashMap<>();

    @Override
    public void addRecipe(Recipe recipe) {
        recipe.setIngredients(ingredients);
        repositoryRecipe.put(++countId, recipe);

    }

    @Override
    public Recipe getRecipe(Integer recipeId) {
        return repositoryRecipe.get(recipeId);
    }

    @Override
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    @Override
    public Ingredient getIngredient(Integer recipeId, Integer ingredientId) {
        return repositoryRecipe.get(recipeId).getIngredients().get(ingredientId - 1);
    }
}
