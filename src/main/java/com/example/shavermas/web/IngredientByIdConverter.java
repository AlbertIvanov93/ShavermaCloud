package com.example.shavermas.web;

import com.example.shavermas.Ingredient;
import com.example.shavermas.data.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


/**
 * Class to covert id string to Ingredient object.
 * Annotation Component specifies this class as bean-component.
 */
@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private IngredientRepository ingredientRepo;

    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    /**
     * Converts id of ingredient to Ingredient object using database.
     *
     * @param id id of Ingredient needed.
     * @return new Ingredient object.
     */
    @Override
    public Ingredient convert(String id) {
        return ingredientRepo.findById(id).orElse(null);
    }
}
