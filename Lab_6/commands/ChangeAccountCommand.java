package commands;

import models.TaxiFleet;
import utils.Menu;

import java.util.Scanner;

public class ChangeAccountCommand implements Command {
    private UserType userType;
    private Menu menu;
    private TaxiFleet taxiFleet;
    private Scanner scanner;

    public ChangeAccountCommand(UserType userType, Menu menu, TaxiFleet taxiFleet, Scanner scanner) {
        this.userType = userType;
        this.menu = menu;
        this.taxiFleet = taxiFleet;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        menu.clearCommands();
        System.out.println("Виберіть тип акаунту: 1 - Адміністратор, 2 - Користувач");
        String userTypeChoice = scanner.nextLine();

        if (userTypeChoice.equals("1")) {
            System.out.print("Введіть пароль: ");
            String password = scanner.nextLine();
            if (password.equals("1111")) {
                System.out.println("Вітаємо, адміністраторе!");
                userType.setType("admin"); // Встановлюємо тип акаунту "admin"
                menu.addCommand("2", new AddCarCommand(taxiFleet));
                menu.addCommand("3", new RemoveCarCommand(taxiFleet));
                menu.addCommand("6", new UpdateCarInfoCommand(taxiFleet));
            } else {
                System.out.println("Невірний пароль. Ви підключені як звичайний користувач.");
                userType.setType("user"); // Якщо пароль неправильний, встановлюємо тип "user"
            }
        } else {
            System.out.println("Вітаємо, користувачу!");
            userType.setType("user"); // Якщо вибрано користувача, встановлюємо тип "user"
        }

        // Додаємо команди для доступних функцій для поточного типу акаунту
        menu.addCommand("1", new ViewCarsCommand(taxiFleet));
        menu.addCommand("4", new SortCarsCommand(taxiFleet));
        menu.addCommand("5", new SearchCarsCommand(taxiFleet));
        menu.addCommand("7", new ChangeAccountCommand(userType, menu, taxiFleet, scanner)); // Додавання можливості змінити акаунт
    }
}
