package com.example.recipeapi.controller;

import com.example.recipeapi.model.Recipe;
import com.example.recipeapi.service.RecipeService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
    private final RecipeService service;
    public RecipeController(RecipeService service) {
        this.service = service;
    }

    // Get paginated & sorted recipes
    @GetMapping
    public Map<String, Object> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit) {

        Page<Recipe> result = service.getAllRecipes(page, limit);

        return Map.of(
                "page", page,
                "limit", limit,
                "total", result.getTotalElements(),
                "data", result.getContent()
        );
    }

    // Search recipes
    @GetMapping("/search")
    public List<Recipe> search(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String cuisine,
            @RequestParam(required = false) Double rating,
            @RequestParam(required = false) Integer total_time) {

        return service.searchRecipes(title, cuisine, rating, total_time);
    }
}
