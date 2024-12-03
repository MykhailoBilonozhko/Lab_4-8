package utils;

import commands.Command;
import java.util.HashMap;
import java.util.Map;

import static LoggerConfig.LoggerConfig.getLogger;

public class Menu {
    private Map<String, Command> commands;

    public Menu() {
        commands = new HashMap<>();
    }

    public void addCommand(String key, Command command) {
        commands.put(key, command);
    }

    public void clearCommands() {
        commands.clear();
    }

    public void display(String userType) {
        System.out.println("Меню:");
        System.out.println("1 - Перегляд автомобілів");
        if (userType.equals("admin")) {
            System.out.println("2 - Додавання автомобіля");
            System.out.println("3 - Видалення автомобіля");
            System.out.println("6 - Оновлення інформації про автомобіль");
        } else {
            System.out.println("4 - Сортування автомобілів");
            System.out.println("5 - Пошук автомобілів");
        }
        System.out.println("7 - Поміняти акаунт");
        System.out.println("0 - Вихід");
    }

    public void executeCommand(String choice, String userType) {
        Command command = commands.get(choice);
        if (command != null) {
            command.execute();
        } else if (choice.equals("0")) {
            System.out.println("Вихід з програми.");
        } else {
            System.out.println("Невірний вибір. Спробуйте ще раз.");
            getLogger().warning("Невірний вибір.");
        }
    }
}