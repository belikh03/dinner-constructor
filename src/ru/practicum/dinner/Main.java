package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine().trim();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    System.out.println("Программа завершила работу.");
                    System.out.println("Возвращайтесь для составления новых Комбо!");
                    return;
                default:
                    System.out.println("Вы ввели несуществующую команду");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine().trim();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine().trim();
        dc.addNewDish(dishType, dishName); // добавляет новое блюдо
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine().trim();

        //реализует ввод типов блюд
        ArrayList<String> combosDishesType = new ArrayList<>();
        while (!nextItem.isEmpty()) {
            if (dc.allDishesDyType.containsKey(nextItem)) {
                combosDishesType.add(nextItem);
            } else {
                System.out.println("Такой тип блюд отсутствует, введите другой тип.");
            }
            nextItem = scanner.nextLine().trim();
        }

        // генерирует комбинации блюд и выведите на экран
        HashMap<String, ArrayList<String>> combos = dc.generateDishCombo(combosDishesType, numberOfCombos);
        for (int i = 1; i <= numberOfCombos; i++) {
            String combo = "Комбо " + i;
            System.out.println(combo);
            System.out.println(combos.get(combo));
        }
    }
}
