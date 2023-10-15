package com.example.shavermas.web;

import com.example.shavermas.Ingredient;
import com.example.shavermas.Shaverma;
import com.example.shavermas.ShavermaOrder;
import com.example.shavermas.data.IngredientRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Controller class for designing shaverma.
 * Annotation Slf4j from lombok generates logger for this class.
 * Annotation Controller defines class as a controller.
 * Annotation RequestMapping("/design") provides the class to handle requests start with "/design".
 * Annotation SessionAttributes("shavermaOrder") indicates that the ShavermaOrder object declared in the class should be maintained at the session level.
 */

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("shavermaOrder")
public class DesignShavermaController {

    private final IngredientRepository ingredientRepo;

    @Autowired
    public DesignShavermaController(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    /**
     * Gets all Ingredients from database, filters them and ads them to model.
     * @param model model to place Ingredient objects.
     */
    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Iterable<Ingredient> ingredients = ingredientRepo.findAll();

        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }

    /**
     * Adds to Model empty object ShavermaOrder with key="design".
     * @return empty ShavermaOrder object.
     */
    @ModelAttribute(name = "shavermaOrder")
    public ShavermaOrder order() {
        return new ShavermaOrder();
    }

    /**
     * Adds to Model empty object Shaverma with key="design".
     * @return empty Shaverma object.
     */
    @ModelAttribute(name = "shaverma")
    public Shaverma shaverma() {
        return new Shaverma();
    }

    /**
     * Method invokes to handle GET request with path "/design".
     * @return the name of view "design".
     */
    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    /**
     * Method to handle POST request. It puts Shaverma object to ShavermaOrder object.
     * Annotation PostMapping tells class annotation RequestMapping that it handles POST request with path "/design".
     * @param shaverma with annotation Valid to check it for validness.
     * @param errors gets errors if shaverma is invalid.
     * @param shavermaOrder with annotation ModelAttribute tells to use ShavermaOrder from Model with method order().
     * @return redirect: sends GET request with path "/orders/current".
     */
    @PostMapping
    public String processShaverma(@Valid Shaverma shaverma, Errors errors, @ModelAttribute ShavermaOrder shavermaOrder) {
        if (errors.hasErrors()) {
            return "design";
        }
        shavermaOrder.addShaverma(shaverma);
        log.info("Processing shaverma: {}", shaverma);

        return "redirect:/orders/current";
    }

    /**
     * Helper method to filter ingredients by type.
     *
     * @param ingredients Iterable of Ingredient objects.
     * @param type type of ingredient to be filtered.
     * @return filtered ingredients.
     */
    private Iterable<Ingredient> filterByType(Iterable<Ingredient> ingredients, Ingredient.Type type) {
        return StreamSupport.stream(ingredients.spliterator(), false)
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
