package com.example.recipeapi;

import com.example.recipeapi.repository.RecipeRepository;
import com.example.recipeapi.model.Recipe;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.io.File;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    private final RecipeRepository repo;
    private final ObjectMapper mapper = new ObjectMapper();

    public DataLoader(RecipeRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) throws Exception {
        File file = new File("recipes.json");
        if (!file.exists()) return;

        List<Recipe> recipes = mapper.readValue(file, new TypeReference<>() {});
        for (Recipe r : recipes) {
            if (r.getRating() != null && r.getRating().isNaN()) r.setRating(null);
            repo.save(r);
        }
        System.out.println("Recipes imported!");
    }
}
