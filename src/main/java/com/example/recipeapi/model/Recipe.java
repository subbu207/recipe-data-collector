package com.example.recipeapi.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.util.Map;

@Entity
@Table(name = "recipes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cuisine;
    private String title;
    private Double rating;
    private Integer prep_time;
    private Integer cook_time;
    private Integer total_time;

    @Column(columnDefinition = "TEXT")
    private String description;

    @JdbcTypeCode(SqlTypes.JSON)   
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> nutrients;

    private String serves;
}
