package com.alimaa.car;

import org.springframework.web.bind.annotation.RestController;


@RestController
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    public void addCar(Car car){

    }
}
