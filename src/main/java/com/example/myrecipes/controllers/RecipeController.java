package com.example.myrecipes.controllers;

import com.example.myrecipes.models.Recipe;
import com.example.myrecipes.services.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/recipe/get/ten")
    public ResponseEntity<List<?>> listTenRecipes() {
        return ResponseEntity.ok(recipeService.listTenRecipes());
    }

}
