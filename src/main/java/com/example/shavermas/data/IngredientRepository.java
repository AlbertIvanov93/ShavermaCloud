package com.example.shavermas.data;

import com.example.shavermas.Ingredient;

import java.util.Optional;

/**
 * Interface of ingredient repository to store all ingredients in database.
 */
public interface IngredientRepository {

    /**
     * Finds all ingredients in database.
     * @return list of all ingredients from database.
     */
    Iterable<Ingredient> findAll();

    /**
     * Finds ingredient by id from database.
     * @param id if of ingredient to be found.
     * @return returns Ingredient object with chosen id.
     */
    Optional<Ingredient> findById(String id);

    /**
     * Saves Ingredient object to database.
     * @param ingredient Ingredient object that should be placed in database.
     * @return the same Ingredient object.
     */
    Ingredient save(Ingredient ingredient);
}
