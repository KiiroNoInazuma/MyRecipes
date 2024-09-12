package com.example.myrecipes.controllers;

import com.example.myrecipes.models.Ingredient;
import com.example.myrecipes.services.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class IngredientController {

    private final IngredientService ingredientService;


    @PostMapping("/ingredient/add")
    public ResponseEntity<Void> addIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.addIngredient(ingredient);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/ingredient/edit/{id}")
    public ResponseEntity<Ingredient> editIngredient(@PathVariable int id, @RequestBody Ingredient ingredient) {
        Ingredient changeIngredient = ingredientService.editIngredient(id, ingredient);
        return ResponseEntity.ok(changeIngredient);
    }

    @DeleteMapping("/ingredient/del/{id}")
    public ResponseEntity<Void> removeIngredient(@PathVariable int id) {
        ingredientService.removeIngredient(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/ingredient/get/{recipeId}")
    public ResponseEntity<Ingredient> getIngredient(@PathVariable int recipeId, @RequestParam int ingredientId) {
        Ingredient ingredient = ingredientService.getIngredient(recipeId, ingredientId);
        return ResponseEntity.ok(ingredient);
    }

    @GetMapping("/ingredient/get/all")
    public ResponseEntity<List<?>> getIngredient() {
        return ResponseEntity.ok(ingredientService.getAllIngredient());
    }

}
