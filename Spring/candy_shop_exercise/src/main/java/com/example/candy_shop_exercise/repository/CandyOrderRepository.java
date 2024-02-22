package com.example.candy_shop_exercise.repository;

import com.example.candy_shop_exercise.entity.CandyOrder;
import org.springframework.data.repository.CrudRepository;

public interface CandyOrderRepository extends CrudRepository<CandyOrder, Long> {
}
