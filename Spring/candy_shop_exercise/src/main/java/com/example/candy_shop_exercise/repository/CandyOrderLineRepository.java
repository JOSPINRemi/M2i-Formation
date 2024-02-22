package com.example.candy_shop_exercise.repository;

import com.example.candy_shop_exercise.entity.CandyOrderLine;
import org.springframework.data.repository.CrudRepository;

public interface CandyOrderLineRepository extends CrudRepository<CandyOrderLine, Long> {
}
