package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishes = new HashMap<>();
    //ArrayList<String> dishesNames = new ArrayList<>();
    Random random = new Random();



    public void addNewDish(String dishType, String dishName) {
        /*for (String currentDishType : dishes.keySet()) {
            if (currentDishType.equals(dishType)){
                ArrayList<String> currentTypeDishes =
            }
        }*/
        if (dishes.containsKey(dishType)) {
            ArrayList<String> currentTypeDishes = dishes.get(dishType);
            if (currentTypeDishes.contains(dishName)) {
                System.out.println("Данное блюдо уже добавлено.");
            } else {
                currentTypeDishes.add(dishName);
            }
        } else {
            ArrayList<String> currentTypeDishes = new ArrayList<>();
            currentTypeDishes.add(dishName);
            dishes.put(dishType, currentTypeDishes);
        }
        ArrayList <String> s = new ArrayList<>();
        s.add("Суп");
        s.add("Борщ");
        s.add("Уха");
        dishes.put("Первое", s);
        ArrayList <String> s1 = new ArrayList<>();
        s1.add("Картошка");
        s1.add("Рыба");
        s1.add("Мясо");
        dishes.put("Второе", s1);
        System.out.println(dishes);
    }

     public HashMap<String, ArrayList<String>> generateDishCombo (ArrayList <String> combosDishesType, int numberOfCombos) {
        HashMap<String, ArrayList<String>> combos = new HashMap<>(numberOfCombos);
         for (int i = numberOfCombos; i >0; i--) {
             ArrayList<String> comboDishes = new ArrayList<>();

             for (String dishesType : combosDishesType) {
                 ArrayList<String> currentTypeDishes = dishes.get(dishesType);
                 String currentDish = currentTypeDishes.get(random.nextInt(currentTypeDishes.size()));
                 comboDishes.add(currentDish);
             }
             combos.put("Комбо " + i , comboDishes );
         }
         return combos;
     }
}
