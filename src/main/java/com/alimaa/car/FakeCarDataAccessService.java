package com.alimaa.car;

import java.util.ArrayList;
import java.util.List;

public class FakeCarDataAccessService implements CarDAO{

    private List<Car> db;

    public FakeCarDataAccessService(){
        this.db = new ArrayList<>();
    }

    @Override
    public Car selectCarById(Integer id) {
        return null;
    }

    @Override
    public List<Car> selectAllCars() {
        return null;
    }

    @Override
    public void insertCar(Car car) {

    }

    @Override
    public int deleteCar(Car car) {
        return 0;
    }

    @Override
    public int updateCar(Integer id, Car update) {
        return 0;
    }
}
