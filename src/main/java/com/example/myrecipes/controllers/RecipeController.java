package com.example.myrecipes.controllers;

import com.example.myrecipes.models.Recipe;
import com.example.myrecipes.services.RecipeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RecipeController {
    private static int x;

    private final RecipeService recipeService;

    @PostMapping("/recipe/add")
    public ResponseEntity<Void> addRecipe(@RequestBody Recipe recipe) {
        recipeService.addRecipe(recipe);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/recipe/get/{recipeId}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable int recipeId) {
        Recipe recipe = recipeService.getRecipe(recipeId);
        LocalTime currentTime = LocalTime.now();
        int currentSeconds = currentTime.getSecond();
        log.info(String.format("test: %s, %s", x++, currentSeconds));
        return ResponseEntity.ok(recipe);
    }

    @GetMapping("/recipe/get/ten")
    public ResponseEntity<List<?>> listTenRecipes() {
        return ResponseEntity.ok(recipeService.listTenRecipes());
    }

}
