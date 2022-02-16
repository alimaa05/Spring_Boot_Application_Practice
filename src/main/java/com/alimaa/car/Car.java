package com.alimaa.car;

import java.util.Objects;

public class Car {
    private Integer id;
    private Brand brand;
    private Double price;

    public Car(Integer id, Brand brand, Double price) {
        this.id = id;
        this.brand = brand;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand=" + brand +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) && brand == car.brand && Objects.equals(price, car.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, price);
    }
}
