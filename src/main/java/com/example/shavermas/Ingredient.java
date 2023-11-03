package com.example.shavermas;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


/**
 * Class for ingredients in shaverma.
 * Annotation Data from lombok generates getters, setters, constructor, hashCode(), toString(), equals()
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Ingredient {

    @Id
    private String id;

    private String name;

    private Type type;

    /**
     * Enum for ingredient type
     */
    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
