package pl.writech.week3.service;

import pl.writech.week3.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<Car> getCars();

    Optional<Car> getCarById(long id);

    Optional<Car> getCarByColor(String color);

    boolean isModifiedCar(Car car);

    boolean isRemovedCar(long id);

    boolean isAddedCar(Car car);
}
