package UnitTest;
import models.Car;
import models.TaxiFleet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TaxiFleetTest {
    private TaxiFleet taxiFleet;
    private final String TEST_FILE_PATH = "D:\\Лаби\\ПП\\TestCars.txt";

    @BeforeEach
    void setUp() {
        taxiFleet = new TaxiFleet(TEST_FILE_PATH);
    }

    @AfterEach
    void tearDown() {
        new File(TEST_FILE_PATH).delete();
    }

    @Test
    void testAddCar() {
        Car car = new Car("Model S", "Tesla", 2021, 200, 8.5, 70000);
        taxiFleet.addCar(car);
        assertEquals(1, taxiFleet.getCars().size());
    }

    @Test
    void testRemoveCar() {
        Car car = new Car("Model X", "Tesla", 2022, 180, 10.0, 90000);
        taxiFleet.addCar(car);
        taxiFleet.removeCar(car);
        assertEquals(0, taxiFleet.getCars().size());
    }

    @Test
    void testUpdateCar() {
        Car car = new Car("Model 3", "Tesla", 2021, 160, 9.0, 35000);
        taxiFleet.addCar(car);
        car.setPrice(30000);
        assertEquals(30000, taxiFleet.getCars().get(0).getPrice());
    }

    @Test
    void testSortByPrice() {
        taxiFleet.addCar(new Car("Model A", "Tesla", 2019, 160, 9.0, 30000));
        taxiFleet.addCar(new Car("Model B", "Tesla", 2021, 180, 8.5, 45000));
        taxiFleet.addCar(new Car("Model C", "Tesla", 2022, 200, 7.5, 60000));

        taxiFleet.sortCarsByPrice();
        assertEquals("Model A", taxiFleet.getCars().get(0).getModel());
        assertEquals("Model B", taxiFleet.getCars().get(1).getModel());
        assertEquals("Model C", taxiFleet.getCars().get(2).getModel());
    }


    @Test
    void testSaveAndLoadFromFile() throws IOException {
        taxiFleet.addCar(new Car("Tesla", "Model Y", 2023, 150, 7.0, 50000));
        taxiFleet.saveToFile();

        TaxiFleet loadedTaxiFleet = new TaxiFleet(TEST_FILE_PATH);
        loadedTaxiFleet.loadFromFile();

        assertEquals(1, loadedTaxiFleet.getCars().size());
        assertEquals("Model Y", loadedTaxiFleet.getCars().get(0).getModel());
    }
}


