package entity;

import org.example.entity.Year;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class YearTest {
    private Year year;

    @BeforeEach
    void initYear() {
        year = new Year();
    }

    @AfterEach
    void undefYear() {
        year = null;
    }

    @Test
    void givenYear2024WhenIsLeapThenIsTrue() {
        Assertions.assertTrue(year.isLeap(2024));
    }

    @Test
    void givenYear2000WhenIsLeapThenIsTrue() {
        Assertions.assertTrue(year.isLeap(2000));
    }

    @Test
    void givenYear8000WhenIsLeapThenIsTrue() {
        Assertions.assertTrue(year.isLeap(8000));
    }

    @Test
    void givenYear2021WhenIsLeapThenIsFalse() {
        Assertions.assertFalse(year.isLeap(2021));
    }

    @Test
    void givenYear200WhenIsLeapThenIsFalse() {
        Assertions.assertFalse(year.isLeap(200));
    }
}
