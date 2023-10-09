package com.example.shavermas;

import lombok.Data;

/**
 * Class for ingredients in shaverma.
 * Annotation Data from lombok generates getters, setters, constructor, hashCode(), toString(), equals()
 */
@Data
public class Ingredient {

    private final String id;
    private final String name;
    private final Type type;

    /**
     * Enum for ingredient type
     */
    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
