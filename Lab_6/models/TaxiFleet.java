package models;

import utils.FileUtil;
import java.util.List;

public class TaxiFleet {
    private List<Car> cars;
    private String filePath;

    public TaxiFleet(String filePath) {
        this.filePath = filePath;
        this.cars = FileUtil.readCarsFromFile(filePath);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void addCar(Car car) {
        cars.add(car);
        FileUtil.writeCarsToFile(cars, filePath);
    }

    public void removeCar(Car car) {
        cars.remove(car);
        FileUtil.writeCarsToFile(cars, filePath);
    }

    public void loadFromFile() {
        cars = FileUtil.readCarsFromFile(filePath);
    }

    public void saveToFile() {
        FileUtil.writeCarsToFile(cars, filePath);
    }

    public void sortCarsByPrice() {

    }
}