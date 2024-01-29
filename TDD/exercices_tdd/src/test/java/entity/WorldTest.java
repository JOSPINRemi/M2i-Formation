package entity;

import org.example.entity.World;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WorldTest {
    private World world;

    @BeforeEach
    void initWorld() {
        world = new World();
    }

    @AfterEach
    void undefWorld() {
        world = null;
    }

    @Test
    void givenCityNamePWhenSearchCitiesThenNotFoundException() {
        Assertions.assertThrowsExactly(RuntimeException.class, () -> world.searchCities("P"));
    }

    @Test
    void givenCityNameStartVaWhenSearchCitiesThenCities() {
        Assertions.assertEquals(List.of("Valence", "Vancouver"), world.searchCities("Va"));
    }

    @Test
    void givenCityNameStartVaWhenSearchCitiesCaseInsensitiveThenCities() {
        Assertions.assertEquals(List.of("Valence", "Vancouver"), world.searchCities("va"));
    }

    @Test
    void givenCityNameContainsApeWhenSearchCitiesThenCities() {
        Assertions.assertEquals(List.of("Budapest"), world.searchCities("ape"));
    }

    @Test
    void givenCityNameAsterisqueWhenSearchCitiesThenCities() {
        Assertions.assertEquals(List.of("Budapest", "Valence", "Vancouver"), world.searchCities("*"));
    }
}
