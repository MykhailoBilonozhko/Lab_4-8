package utils;

import models.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static LoggerConfig.LoggerConfig.getLogger;

public class FileUtil {
    public static List<Car> readCarsFromFile(String filePath) {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] carData = line.split(",");
                if (carData.length == 6) {
                    String model = carData[0];
                    String brand = carData[1];
                    int year = Integer.parseInt(carData[2]);
                    int speed = Integer.parseInt(carData[3]);
                    double fuelConsumption = Double.parseDouble(carData[4]);
                    double price = Double.parseDouble(carData[5]);
                    cars.add(new Car(model, brand, year, speed, fuelConsumption, price));
                }
            }
        } catch (IOException e) {
            getLogger().severe(e.getMessage());
        }
        return cars;
    }


    public static void writeCarsToFile(List<Car> cars, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Car car : cars) {
                String carData = String.join(",",
                        car.getBrand(),
                        car.getModel(),
                        String.valueOf(car.getYear()),
                        String.valueOf(car.getSpeed()),
                        String.valueOf(car.getFuelConsumption()),
                        String.valueOf(car.getPrice()));
                writer.write(carData);
                writer.newLine();
            }
            System.out.println("Дані автомобілів успішно збережено до файлу.");
        } catch (IOException e) {
            getLogger().severe(e.getMessage());
        }
    }
}