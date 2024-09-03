package com.example.myrecipes.models;

import lombok.Data;

import java.util.List;

@Data
public class Recipe {

    private final String name;
    private final Integer timeCooking;
    private List<Ingredient> ingredients;
    private final List<String> stepsCooking;
}

