package com.alimaa.car;

import java.util.List;

public interface CarDAO {
    Car selectCarById(Integer id);
    List<Car> selectAllCars();
    void insertCar(Car car);
    int deleteCar(Car car);
    int updateCar(Integer id, Car update);
}
