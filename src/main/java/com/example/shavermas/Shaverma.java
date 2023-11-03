package com.example.shavermas;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class for shaverma. It contains name of shaverma and list of its ingredients
 * Annotation Data from lombok generates getters, setters, constructor, hashCode(), toString(), equals()
 */
@Data
@Entity
public class Shaverma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date createdAt = new Date();

    /**
     * Name of shaverma. Must be not null and at least 5 characters long.
     */
    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    /**
     * List of ingredients. Must contain at least 1 ingredient.
     */
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    @ManyToMany()
    private List<Ingredient> ingredients = new ArrayList<>();

    /**
     * Add ingredient to List of ingredients.
     * @param ingredient to add to ingredients.
     */
    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
}
