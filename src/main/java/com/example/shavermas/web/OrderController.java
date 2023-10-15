package com.example.shavermas.web;

import com.example.shavermas.ShavermaOrder;
import com.example.shavermas.data.OrderRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * Class for order controller.
 * Annotation Controller defines class as a controller.
 * Annotation RequestMapping("/orders") provides the class to handle requests start with "/orders".
 * Annotation SessionAttributes("shavermaOrder") indicates that the ShavermaOrder object declared in the class should be maintained at the session level.
 */
@Controller
@RequestMapping("/orders")
@SessionAttributes("shavermaOrder")
public class OrderController {

    private OrderRepository orderRepo;

    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    /**
     * Method invokes to handle GET request with path "/orders/current".
     * @return the name of view "orderForm".
     */
    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    /**
     * Method to handle POST request.Method receives ShavermaOrder object from orderForm.
     * It saves ShavermaOrder object into DB. Completes session of creating shaverma.
     * @param order with annotation Valid to check it for validness.
     * @param errors gets errors if order invalid.
     * @param sessionStatus
     * @return redirect: sends GET request with path "/".
     */
    @PostMapping
    public String processOrder(@Valid ShavermaOrder order, Errors errors, SessionStatus sessionStatus) {
        if(errors.hasErrors()) {
            return "orderForm";
        }

        orderRepo.save(order);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
