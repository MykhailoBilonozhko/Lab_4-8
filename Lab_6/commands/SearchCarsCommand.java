package commands;

import models.Car;
import models.TaxiFleet;


import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static LoggerConfig.LoggerConfig.getLogger;

public class SearchCarsCommand implements Command {
    private TaxiFleet taxiFleet;

    public SearchCarsCommand(TaxiFleet taxiFleet) {
        this.taxiFleet = taxiFleet;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть марку автомобіля: ");
        String brand = scanner.nextLine();

        boolean carFound = false; // Додано для перевірки, чи знайдено автомобіль
        for (Car car : taxiFleet.getCars()) {
            if (car.getBrand().equalsIgnoreCase(brand)) {
                getLogger().info("Автомобілі знайдено для марки: " + brand);
                System.out.println(car);
                carFound = true; // Якщо автомобіль знайдено
            }
        }
        if (!carFound) {
            getLogger().warning("Автомобіль " + brand + " не знайдено");
        }
    }
}