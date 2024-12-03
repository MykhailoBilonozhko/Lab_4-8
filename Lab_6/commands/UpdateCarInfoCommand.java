package commands;

import models.Car;
import models.TaxiFleet;
import java.util.Scanner;

import static LoggerConfig.LoggerConfig.getLogger;

public class UpdateCarInfoCommand implements Command {
    private TaxiFleet taxiFleet;

    public UpdateCarInfoCommand(TaxiFleet taxiFleet) {
        this.taxiFleet = taxiFleet;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть модель автомобіля для оновлення: ");
        String modelToUpdate = scanner.nextLine();

        Car carToUpdate = null;
        for (Car car : taxiFleet.getCars()) {
            if (car.getModel().equalsIgnoreCase(modelToUpdate)) {
                carToUpdate = car;
                break;
            }
        }

        if (carToUpdate != null) {
            System.out.println("Автомобіль знайдено. Введіть нові дані (залиште порожнім, щоб не змінювати):");

            System.out.print("Нова модель (поточна: " + carToUpdate.getModel() + "): ");
            String newModel = scanner.nextLine();
            if (!newModel.isEmpty()) {
                carToUpdate.setBrand(newModel);
            }

            System.out.print("Нова марка (поточна: " + carToUpdate.getBrand() + "): ");
            String newBrand = scanner.nextLine();
            if (!newBrand.isEmpty()) {
                carToUpdate.setBrand(newBrand);
            }

            System.out.print("Новий рік випуску (поточний: " + carToUpdate.getYear() + "): ");
            String yearInput = scanner.nextLine();
            if (!yearInput.isEmpty()) {
                carToUpdate.setYear(Integer.parseInt(yearInput));
            }

            System.out.print("Нова швидкість (поточна: " + carToUpdate.getSpeed() + "): ");
            String newSpeed = scanner.nextLine();
            if (!newSpeed.isEmpty()) {
                carToUpdate.setYear(Integer.parseInt(newSpeed));
            }

            System.out.print("Нова витрата пального (поточна: " + carToUpdate.getFuelConsumption() + "): ");
            String fuelConsumptionInput = scanner.nextLine();
            if (!fuelConsumptionInput.isEmpty()) {
                carToUpdate.setFuelConsumption(Double.parseDouble(fuelConsumptionInput));
            }

            System.out.print("Нова ціна (поточна: " + carToUpdate.getPrice() + "): ");
            String priceInput = scanner.nextLine();
            if (!priceInput.isEmpty()) {
                carToUpdate.setPrice(Double.parseDouble(priceInput));
            }

            taxiFleet.saveToFile();  // Update the file after changes
            System.out.println("Інформацію про автомобіль оновлено.");
            getLogger().info("Інформацію про автомобіль оновлено.");
        } else {
            System.out.println("Автомобіль не знайдено.");
            getLogger().warning("Інформацію про автомобіль не оновлено.");
        }
    }
}