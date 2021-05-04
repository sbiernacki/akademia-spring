package pl.writech.week3.service;

import pl.writech.week3.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    public List<Car> getCars();
    public Optional<Car> getCarById(long id);
    public Optional<Car> getCarByColor(String color);
    public boolean isModifiedCar(Car car);
    public boolean isRemovedCar(long id);
    public boolean isAddedCar(Car car);
}
