package com.alimaa.car;

public class CarService {
    // use the interface instead so you can swap it out for anything that uses that interface
    // can switch out how our application stores data

    private CarDAO carDAO;

    public CarService(CarDAO carDAO){
        this.carDAO = carDAO;
    }



}
