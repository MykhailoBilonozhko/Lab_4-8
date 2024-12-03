package Main;
import commands.*;
import models.TaxiFleet;
import utils.Menu;

import java.util.Scanner;

public class Main {
    private static final String FILE_PATH = "D:\\Лаби\\ПП\\Turs.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        TaxiFleet taxiFleet = new TaxiFleet(FILE_PATH);

        taxiFleet.loadFromFile();

        // Створюємо об'єкт UserType для зберігання типу акаунту
        UserType userType = new UserType("user"); // Початково встановлюємо тип як "user"

        // Створюємо команду для зміни акаунту
        ChangeAccountCommand changeAccountCommand = new ChangeAccountCommand(userType, menu, taxiFleet, scanner);

        // Виконуємо команду вибору акаунту
        changeAccountCommand.execute();

        String choice;
        do {
            menu.display(userType.getType());
            choice = scanner.nextLine();
            menu.executeCommand(choice, userType.getType());

        } while (!choice.equals("0"));

        scanner.close();
    }
}
