package commands;

import models.Car;
import models.TaxiFleet;
import LoggerConfig.LoggerConfig;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static LoggerConfig.LoggerConfig.getLogger;


public class RemoveCarCommand implements Command {
    private TaxiFleet taxiFleet;

    public RemoveCarCommand(TaxiFleet taxiFleet) {
        this.taxiFleet = taxiFleet;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть марку автомобіля для видалення: ");
        String brandToRemove = scanner.nextLine();

        Car carToRemove = null;
        for (Car car : taxiFleet.getCars()) {
            if (car.getBrand().equalsIgnoreCase(brandToRemove)) {
                carToRemove = car;
                break;
            }
        }

        if (carToRemove != null) {
            taxiFleet.removeCar(carToRemove);
            getLogger().info("Автомобіль видалено: " + carToRemove);
            System.out.println("Автомобіль видалено.");
        } else {
            System.out.println("Автомобіль не знайдено.");
            getLogger().warning("Автомобіль не знайдено");
        }
    }
}