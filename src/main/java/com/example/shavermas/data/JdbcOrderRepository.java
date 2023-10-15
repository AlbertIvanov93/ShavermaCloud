package com.example.shavermas.data;

import com.example.shavermas.Ingredient;
import com.example.shavermas.IngredientRef;
import com.example.shavermas.Shaverma;
import com.example.shavermas.ShavermaOrder;
import org.springframework.asm.Type;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * Class for saving ShavermaOrder object into database.
 */
@Repository
public class JdbcOrderRepository implements OrderRepository {

    private JdbcOperations jdbcOperations;

    public JdbcOrderRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    /**
     * Saves ShavermaOrder object into database. It also specifies id and DateTime of creation.
     *
     * @param order ShavermaOrder object to save in DB.
     * @return the same ShavermaOrder object;
     */
    @Override
    @Transactional
    public ShavermaOrder save(ShavermaOrder order) {
        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
                "INSERT INTO Shaverma_Order "
                        + "(delivery_name, delivery_Street, delivery_City, "
                        + "delivery_State, delivery_Zip, cc_number, "
                        + "cc_expiration, cc_cvv, placed_at) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP
        );
        pscf.setReturnGeneratedKeys(true);

        order.setPlacedAt(new Date());
        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
                Arrays.asList(
                        order.getDeliveryName(),
                        order.getDeliveryStreet(),
                        order.getDeliveryCity(),
                        order.getDeliveryState(),
                        order.getDeliveryZip(),
                        order.getCcNumber(),
                        order.getCcExpiration(),
                        order.getCcCVV(),
                        order.getPlacedAt()
                )
        );

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, keyHolder);
        long orderId = keyHolder.getKey().longValue();
        order.setId(orderId);

        List<Shaverma> shavermas = order.getShavermas();
        int i = 0;
        for (Shaverma shaverma : shavermas) {
            saveShaverma(orderId, i++, shaverma);
        }
        return order;
    }

    /**
     * Saves Shaverma object in order to db. It also specifies id and DateTime of creation.
     *
     * @param orderId  id of ShavermaOrder object.
     * @param orderKey key of ShavermaOrder object.
     * @param shaverma Shaverma object that need to save into DB.
     * @return id of Shaverma object.
     */
    private long saveShaverma(Long orderId, int orderKey, Shaverma shaverma) {
        shaverma.setCreatedAt(new Date());
        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
                "INSERT INTO Shaverma "
                        + "(name, created_at, shaverma_order, shaverma_order_key) "
                        + "VALUES (?, ?, ?, ?)",
                Types.VARCHAR, Types.TIMESTAMP, Type.LONG, Type.LONG
        );
        pscf.setReturnGeneratedKeys(true);

        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
                Arrays.asList(
                        shaverma.getName(),
                        shaverma.getCreatedAt(),
                        orderId,
                        orderKey
                )
        );

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, keyHolder);
        long shavermaId = keyHolder.getKey().longValue();
        shaverma.setId(shavermaId);

        saveIngredienRefs(shavermaId, shaverma.getIngredients());

        return shavermaId;
    }

    private void saveIngredienRefs(long shavermaId, List<IngredientRef> ingredientRefs) {
        int key = 0;
        for (IngredientRef ingredientRef : ingredientRefs) {
            jdbcOperations.update(
                    "INSERT INTO Ingredient_Ref (ingredient, shaverma, shaverma_key) "
                            + "VALUES (?, ?, ?)",
                    ingredientRef.getIngredient(), shavermaId, key++
            );
        }
    }
}
