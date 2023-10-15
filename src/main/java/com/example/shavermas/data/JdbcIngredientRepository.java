package com.example.shavermas.data;

import com.example.shavermas.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


/**
 * Implementation of IngredientRepository using JDBC. Uses to store Ingredient objects in database and operate with them.
 */
@Repository
public class JdbcIngredientRepository implements IngredientRepository {

    private JdbcTemplate jdbcTemplate;


    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Finds all ingredients in database.
     *
     * @return list of all ingredients from database.
     */
    @Override
    public Iterable<Ingredient> findAll() {
        return jdbcTemplate.query(
                "SELECT id, name, type from Ingredient",
                this::mapRowToIngredient);
    }

    /**
     * Finds ingredient by id from database.
     *
     * @param id if of ingredient to be found.
     * @return returns Ingredient object with chosen id.
     */
    @Override
    public Optional<Ingredient> findById(String id) {
        List<Ingredient> results = jdbcTemplate.query(
                "SELECT id, name, type FROM Ingredient WHERE id=?",
                this::mapRowToIngredient,
                id);
        return results.size() == 0 ? Optional.empty() : Optional.of(results.get(0));
    }

    private Ingredient mapRowToIngredient(ResultSet row, int rowNum) throws SQLException {
        return new Ingredient(row.getString("id"),
                row.getString("name"),
                Ingredient.Type.valueOf(row.getString("type")));
    }

    /**
     * Saves Ingredient object to database.
     *
     * @param ingredient Ingredient object that should be placed in database.
     * @return the same Ingredient object.
     */
    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbcTemplate.update(
                "INSERT INTO Ingredient (id, name, type) VALUES (?, ?, ?)",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString());
        return ingredient;
    }
}
