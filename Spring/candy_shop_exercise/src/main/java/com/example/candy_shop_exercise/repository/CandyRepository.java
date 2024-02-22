package com.example.candy_shop_exercise.repository;

import com.example.candy_shop_exercise.entity.Candy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


@RepositoryRestResource(path = "candies", collectionResourceRel = "candies")
public interface CandyRepository extends CrudRepository<Candy, Long> {

    @RestResource(path = "searchname")
    List<Candy> findAllByNameContaining(@Param("name") String name);
    List<Candy> findAllByMagicEffect(String magicEffect);
    List<Candy> findAllByPriceBetween(double minPrice, double maxPrice);

    @RestResource(exported = false)
    void deleteById(long id);

}
