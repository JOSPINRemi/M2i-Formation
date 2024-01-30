package entity;

import org.example.entity.Car;
import org.example.entity.CarRentalAgency;
import org.example.exception.ConditionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CarRentalAgencyTest {
    private CarRentalAgency agency;

    @BeforeEach
    void initCarRentalAgency() {
        agency = new CarRentalAgency();
    }

    @Test
    void givenRentDueIn0WhenDailyRoutineThenDecreaseConditionTwice() {
        int rentDueIn = 0;
        int condition = 50;
        Car car = Car.builder()
                .rentDueIn(rentDueIn)
                .condition(condition)
                .build();
        agency.setCars(List.of(car));
        agency.dailyRoutine();

        Car expectedCar = Car.builder()
                .rentDueIn(-1)
                .condition(48)
                .build();
        Assertions.assertEquals(expectedCar, agency.getCars().get(0));
    }

    @Test
    void givenCondition0WhenDailyRoutineThenRaiseConditionException() {
        int rentDueIn = 10;
        int condition = 0;
        Car car = Car.builder()
                .rentDueIn(rentDueIn)
                .condition(condition)
                .build();
        agency.setCars(List.of(car));

        Assertions.assertThrowsExactly(ConditionException.class, () -> agency.dailyRoutine());
    }

    @Test
    void givenCondition101WhenDailyRoutineThenRaiseConditionException() {
        int rentDueIn = 10;
        int condition = 101;
        Car car = Car.builder()
                .rentDueIn(rentDueIn)
                .condition(condition)
                .build();
        agency.setCars(List.of(car));

        Assertions.assertThrowsExactly(ConditionException.class, () -> agency.dailyRoutine());
    }

    @Test
    void givenLuxuryWhenDailyRoutineThenIncreaseCondition() {
        int rentDueIn = 10;
        int condition = 10;
        Car car = Car.builder()
                .rentDueIn(rentDueIn)
                .condition(condition)
                .luxury(true)
                .build();
        agency.setCars(List.of(car));
        agency.dailyRoutine();

        Car expectedCar = Car.builder()
                .rentDueIn(9)
                .condition(11)
                .luxury(true)
                .build();
        Assertions.assertEquals(expectedCar, agency.getCars().get(0));
    }

    @Test
    void givenOldWhenDailyRoutineThenDecreaseConditionTwice() {
        int rentDueIn = 10;
        int condition = 10;
        Car car = Car.builder()
                .rentDueIn(rentDueIn)
                .condition(condition)
                .old(true)
                .build();
        agency.setCars(List.of(car));
        agency.dailyRoutine();

        Car expectedCar = Car.builder()
                .rentDueIn(9)
                .condition(8)
                .old(true)
                .build();
        Assertions.assertEquals(expectedCar, agency.getCars().get(0));
    }

    @Test
    void givenOldRentDueIn0WhenDailyRoutineThenDecreaseConditionTwice() {
        int rentDueIn = 0;
        int condition = 10;
        Car car = Car.builder()
                .rentDueIn(rentDueIn)
                .condition(condition)
                .old(true)
                .build();
        agency.setCars(List.of(car));
        agency.dailyRoutine();

        Car expectedCar = Car.builder()
                .rentDueIn(-1)
                .condition(6)
                .old(true)
                .build();
        Assertions.assertEquals(expectedCar, agency.getCars().get(0));
    }
}
