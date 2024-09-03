package com.example.myrecipes.controllers;

import com.example.myrecipes.models.Ingredient;
import com.example.myrecipes.models.Recipe;
import com.example.myrecipes.services.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @PostMapping("/recipe/add")
    public ResponseEntity<Void> addRecipe(@RequestBody Recipe recipe) {
        recipeService.addRecipe(recipe);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/recipe/get/{recipeId}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable int recipeId) {
        Recipe recipe = recipeService.getRecipe(recipeId);
        return ResponseEntity.ok(recipe);
    }

    @PostMapping("/ingredient/add")
    public ResponseEntity<Void> addIngredient(@RequestBody Ingredient ingredient) {
        recipeService.addIngredient(ingredient);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/ingredient/get/{recipeId}")
    public ResponseEntity<Ingredient> getIngredient(@PathVariable int recipeId, @RequestParam int ingredientId) {
        Ingredient ingredient = recipeService.getIngredient(recipeId, ingredientId);
        return ResponseEntity.ok(ingredient);
    }
}
