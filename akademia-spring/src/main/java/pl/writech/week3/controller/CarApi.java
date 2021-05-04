package pl.writech.week3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.writech.week3.model.Car;
import pl.writech.week3.service.CarService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarApi {

    private CarService carService;

    @Autowired
    public CarApi(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Car>> getCars() {
        return new ResponseEntity<>(carService.getCars(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable long id) {
        Optional<Car> optionalCar = carService.getCarById(id);

        return optionalCar.map(car -> new ResponseEntity<>(car, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/color/{color}")
    public ResponseEntity<Car> getCarByColor(@PathVariable String color) {
        Optional<Car> optionalCar = carService.getCarByColor(color);

        return optionalCar.map(car -> new ResponseEntity<>(car, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity addCar(@RequestBody Car car) {
        boolean isAdded = carService.isAddedCar(car);
        if (isAdded) {
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping
    public ResponseEntity modifyCar(@RequestBody Car requestCar) {
        if (carService.isModifiedCar(requestCar)) {
            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removeCar(@PathVariable long id) {
        if (carService.isRemovedCar(id)) {
            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


}
