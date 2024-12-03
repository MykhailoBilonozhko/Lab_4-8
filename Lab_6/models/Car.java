package models;

public class Car {
    private String model;
    private String brand;
    private int year;
    private int speed;
    private double fuelConsumption;
    private double price;

    public Car(String model, String brand, int year, int speed, double fuelConsumption, double price) {
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.speed = speed;
        this.fuelConsumption = fuelConsumption;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public int getSpeed() {
        return speed;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getPrice() {
        return price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return
                "Марка: '" + brand + '\'' +
                        ", Модель: '" + model + '\'' +
                        ", Рік випуску: " + year +
                        ", Максимальна швидкість: " + speed +
                        ", Витрата палива: " + fuelConsumption +
                        ", Ціна: " + price;
    }
}