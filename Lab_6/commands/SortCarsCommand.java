package commands;

import models.Car;
import models.TaxiFleet;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SortCarsCommand implements Command {
    private TaxiFleet taxiFleet;

    public SortCarsCommand(TaxiFleet taxiFleet) {
        this.taxiFleet = taxiFleet;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сортувати за:");
        System.out.println("1 - Ціною");
        System.out.println("2 - Швидкістю");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                Collections.sort(taxiFleet.getCars(), Comparator.comparingDouble(Car::getPrice));
                System.out.println("Автомобілі відсортовано за ціною.");
                break;
            case "2":
                Collections.sort(taxiFleet.getCars(), Comparator.comparingDouble(Car::getSpeed));
                System.out.println("Автомобілі відсортовано за швидкістю.");
                break;
            default:
                System.out.println("Невірний вибір.");
                return;
        }

        System.out.println("Відсортовані автомобілі:");
        for (Car car : taxiFleet.getCars()) {
            System.out.println(car);
        }
    }
}