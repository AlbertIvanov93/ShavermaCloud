package com.example.shavermas.data;

import com.example.shavermas.ShavermaOrder;
import org.springframework.data.repository.CrudRepository;


public interface OrderRepository extends CrudRepository<ShavermaOrder, Long> {

}
