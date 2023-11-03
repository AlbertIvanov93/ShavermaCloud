package com.example.shavermas;

import com.example.shavermas.data.IngredientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Main class of ShavermaCLoud app.
 */
@SpringBootApplication
public class ShavermaCloudApplication {
	/**
	 * Runs ShavermaCloud app.
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ShavermaCloudApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(IngredientRepository repo) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				repo.save(new Ingredient("LAVA", "Lavash", Ingredient.Type.WRAP));
				repo.save(new Ingredient("CHLA", "Cheese Lavash", Ingredient.Type.WRAP));
				repo.save(new Ingredient("PITA", "Pita", Ingredient.Type.WRAP));
				repo.save(new Ingredient("ONPL", "On Plate", Ingredient.Type.WRAP));
				repo.save(new Ingredient("PORK", "Pork", Ingredient.Type.PROTEIN));
				repo.save(new Ingredient("CHIC", "Chicken", Ingredient.Type.PROTEIN));
				repo.save(new Ingredient("ONIO", "Onion", Ingredient.Type.VEGGIES));
				repo.save(new Ingredient("CUCU", "Cucumber", Ingredient.Type.VEGGIES));
				repo.save(new Ingredient("PICK", "Pickles", Ingredient.Type.VEGGIES));
				repo.save(new Ingredient("TOMA", "Tomato", Ingredient.Type.VEGGIES));
				repo.save(new Ingredient("KCAR", "Korean Carrots", Ingredient.Type.VEGGIES));
				repo.save(new Ingredient("JALA", "Jalapeno", Ingredient.Type.VEGGIES));
				repo.save(new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE));
				repo.save(new Ingredient("PARM", "Parmesan", Ingredient.Type.CHEESE));
				repo.save(new Ingredient("GASA", "Garlic Sauce", Ingredient.Type.SAUCE));
				repo.save(new Ingredient("SPSA", "Spicy Sauce", Ingredient.Type.SAUCE));
				repo.save(new Ingredient("SCSA", "Sour Cream Sauce", Ingredient.Type.SAUCE));

			}
		};
	}

}
