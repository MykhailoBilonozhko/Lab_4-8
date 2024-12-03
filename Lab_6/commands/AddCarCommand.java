package commands;

import models.Car;
import models.TaxiFleet;

import java.util.Scanner;

import static LoggerConfig.LoggerConfig.getLogger;

public class AddCarCommand implements Command {
    private TaxiFleet taxiFleet;

    public AddCarCommand(TaxiFleet taxiFleet) {
        this.taxiFleet = taxiFleet;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введіть марку автомобіля: ");
            String brand = scanner.nextLine();
            System.out.print("Введіть модель автомобіля: ");
            String model = scanner.nextLine();
            System.out.print("Введіть рік випуску: ");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.print("Введіть максимальну швидкість: ");
            int speed = Integer.parseInt(scanner.nextLine());
            System.out.print("Введіть витрату пального: ");
            double fuelConsumption = Double.parseDouble(scanner.nextLine());
            System.out.print("Введіть ціну автомобіля: ");
            double price = Double.parseDouble(scanner.nextLine());

            Car car = new Car(model, brand, year, speed, fuelConsumption, price);
            taxiFleet.addCar(car);
            System.out.println("Автомобіль додано.");
            getLogger().info("Автомобіль додано: " + car);
        } catch (NumberFormatException e) {
            System.out.println("Помилка: введіть коректні числові значення.");
        }
    }
}
