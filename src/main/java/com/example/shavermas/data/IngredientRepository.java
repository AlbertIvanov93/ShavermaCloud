package com.example.shavermas.data;

import com.example.shavermas.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Interface of ingredient repository to store all ingredients in database.
 */
public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
