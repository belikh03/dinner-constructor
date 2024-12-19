package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> allDishesDyType = new HashMap<>();
    Random random = new Random();


    public void addNewDish(String dishType, String dishName) {
        if (allDishesDyType.containsKey(dishType)) {
            ArrayList<String> currentTypeDishes = allDishesDyType.get(dishType);
            if (currentTypeDishes.contains(dishName)) {
                System.out.println("Данное блюдо уже добавлено.");
            } else {
                currentTypeDishes.add(dishName);
            }
        } else {
            ArrayList<String> currentTypeDishes = new ArrayList<>();
            currentTypeDishes.add(dishName);
            allDishesDyType.put(dishType, currentTypeDishes);
        }
    }

    public HashMap<String, ArrayList<String>> generateDishCombo(ArrayList<String> combosDishesType,
                                                                int numberOfCombos) {
        HashMap<String, ArrayList<String>> combos = new HashMap<>(numberOfCombos);
        for (int i = numberOfCombos; i > 0; i--) {
            ArrayList<String> comboDishes = new ArrayList<>();
            for (String dishesType : combosDishesType) {
                ArrayList<String> currentTypeDishes = allDishesDyType.get(dishesType);
                String currentDish = currentTypeDishes.get(random.nextInt(currentTypeDishes.size()));
                comboDishes.add(currentDish);
            }
            combos.put("Комбо " + i, comboDishes);
        }
        return combos;
    }
}
