package com.example.shavermas;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Class for shaverma. It contains name of shaverma and list of its ingredients
 * Annotation Data from lombok generates getters, setters, constructor, hashCode(), toString(), equals()
 */
@Data
public class Shaverma {

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
    @NotNull
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<IngredientRef> ingredients;
}
