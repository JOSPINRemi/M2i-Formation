package org.example.entity;

import org.example.exception.ConditionException;

import java.util.List;

public class CarRentalAgency {
    List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void dailyRoutine() {
        for (Car car : cars) {
            if (car.getCondition() < 100) {
                if (car.isLuxury()) {
                    car.setCondition(car.getCondition() + 1);
                    car.setRentDueIn(car.getRentDueIn() - 1);
                    continue;
                } else if (car.isOld()) {
                    if ((car.getRentDueIn() > 0 && car.getCondition() >= 2) || (car.getRentDueIn() <= 0 && car.getCondition() >= 4)) {
                        if (car.getRentDueIn() > 0) {
                            car.setCondition(car.getCondition() - 2);
                        }
                        if (car.getRentDueIn() <= 0) {
                            car.setCondition(car.getCondition() - 4);
                        }
                        car.setRentDueIn(car.getRentDueIn() - 1);
                        continue;
                    }
                } else if ((car.getRentDueIn() > 0 && car.getCondition() >= 1) || (car.getRentDueIn() <= 0 && car.getCondition() >= 2)) {
                    if (car.getRentDueIn() > 0) {
                        car.setCondition(car.getCondition() - 1);
                    }
                    if (car.getRentDueIn() <= 0) {
                        car.setCondition(car.getCondition() - 2);
                    }
                    car.setRentDueIn(car.getRentDueIn() - 1);
                    continue;
                }
            }
            throw new ConditionException();
        }
    }
}
