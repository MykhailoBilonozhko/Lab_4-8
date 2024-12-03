package commands;

import models.TaxiFleet;
import models.Car;

import static LoggerConfig.LoggerConfig.getLogger;

public class ViewCarsCommand implements Command {
    private TaxiFleet taxiFleet;

    public ViewCarsCommand(TaxiFleet taxiFleet) {
        this.taxiFleet = taxiFleet;
    }

    @Override
    public void execute() {
        System.out.println("Автомобілі в таксопарку:");
        for (Car car : taxiFleet.getCars()) {
            System.out.println(car);
        }
        if (taxiFleet.getCars().isEmpty()) {
            System.out.println("Немає автомобілів у таксопарку.");
            getLogger().warning("Немає автомобілів у таксопарку.");
        }
    }
}