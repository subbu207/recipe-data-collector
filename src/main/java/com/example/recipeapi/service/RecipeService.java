package com.example.recipeapi.service;

import com.example.recipeapi.repository.RecipeRepository;;
import com.example.recipeapi.model.Recipe;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class RecipeService {
    private final RecipeRepository repo;

    public RecipeService(RecipeRepository repo) {
        this.repo = repo;
    }

    public Page<Recipe> getAllRecipes(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("rating").descending());
        return repo.findAll(pageable);
    }

    public List<Recipe> searchRecipes(String title, String cuisine, Double rating, Integer totalTime) {
        return repo.findAll((Specification<Recipe>) (root, query, cb) -> {
            List<jakarta.persistence.criteria.Predicate> predicates = new ArrayList<>();
            if (title != null) predicates.add(cb.like(root.get("title"), "%" + title + "%"));
            if (cuisine != null) predicates.add(cb.equal(root.get("cuisine"), cuisine));
            if (rating != null) predicates.add(cb.greaterThanOrEqualTo(root.get("rating"), rating));
            if (totalTime != null) predicates.add(cb.lessThanOrEqualTo(root.get("total_time"), totalTime));
            return cb.and(predicates.toArray(new jakarta.persistence.criteria.Predicate[0]));
        });
    }
}
