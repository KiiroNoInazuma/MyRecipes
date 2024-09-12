package com.example.myrecipes.services.impl;

import com.example.myrecipes.models.Ingredient;
import com.example.myrecipes.services.IngredientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.example.myrecipes.services.impl.RecipeServiceImpl.repositoryRecipe;

@Service
@Slf4j
public class IngredientServiceImpl implements IngredientService {
    public static final List<Ingredient> ingredients = new ArrayList<>();


    @Override
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    @Override
    public Ingredient getIngredient(Integer recipeId, Integer ingredientId) {
        return repositoryRecipe.get(recipeId).getIngredients().get(ingredientId - 1);
    }
}
