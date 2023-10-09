package com.example.shavermas;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for shaverma order. It contains delivery, credit card information and list of shavermas in order.
 * Annotation Data from lombok generates getters, setters, constructor, hashCode(), toString(), equals().
 */
@Data
public class ShavermaOrder {

    @NotBlank(message = "Delivery name is required")
    private String deliveryName;

    @NotBlank(message = "Street is required")
    private String deliveryStreet;

    @NotBlank(message = "City is required")
    private String deliveryCity;

    @NotBlank(message = "State is required")
    private String deliveryState;

    @NotBlank(message = "Zip code is required")
    private String deliveryZip;

    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message = "Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;

    private List<Shaverma> shavermas = new ArrayList<>();

    /**
     * Adds shaverma to list of order.
     * @param shaverma
     */
    public void addShaverma(Shaverma shaverma) {
        this.shavermas.add(shaverma);
    }

    //517-42-23
}
