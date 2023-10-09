package com.example.shavermas.web;

import com.example.shavermas.Ingredient;
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

    private Map<String, Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter() {
        ingredientMap.put("LAVA", new Ingredient("LAVA", "Lavash", Ingredient.Type.WRAP));
        ingredientMap.put("CHLA", new Ingredient("CHLA", "Cheese Lavash", Ingredient.Type.WRAP));
        ingredientMap.put("PITA", new Ingredient("PITA", "Pita", Ingredient.Type.WRAP));
        ingredientMap.put("ONPL", new Ingredient("ONPL", "On Plate", Ingredient.Type.WRAP));
        ingredientMap.put("PORK", new Ingredient("PORK", "Pork", Ingredient.Type.PROTEIN));
        ingredientMap.put("CHIC", new Ingredient("CHIC", "Chicken", Ingredient.Type.PROTEIN));
        ingredientMap.put("ONIO", new Ingredient("ONIO", "Onion", Ingredient.Type.VEGGIES));
        ingredientMap.put("CUCU", new Ingredient("CUCU", "Cucumber", Ingredient.Type.VEGGIES));
        ingredientMap.put("PICK", new Ingredient("PICK", "Pickles", Ingredient.Type.VEGGIES));
        ingredientMap.put("TOMA", new Ingredient("TOMA", "Tomato", Ingredient.Type.VEGGIES));
        ingredientMap.put("KCAR", new Ingredient("KCAR", "Korean Carrots", Ingredient.Type.VEGGIES));
        ingredientMap.put("JALA", new Ingredient("JALA", "Jalapeno", Ingredient.Type.VEGGIES));
        ingredientMap.put("CHED", new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE));
        ingredientMap.put("PARM", new Ingredient("PARM", "Parmesan", Ingredient.Type.CHEESE));
        ingredientMap.put("GASA", new Ingredient("GASA", "Garlic Sauce", Ingredient.Type.SAUCE));
        ingredientMap.put("SPSA", new Ingredient("SPSA", "Spicy Sauce", Ingredient.Type.SAUCE));
        ingredientMap.put("SCSA", new Ingredient("SCSA", "Sour Cream Sauce", Ingredient.Type.SAUCE));
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientMap.get(id);
    }
}
