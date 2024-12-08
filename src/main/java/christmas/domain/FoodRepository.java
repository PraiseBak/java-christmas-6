package christmas.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FoodRepository {
    private final static Map<String,Food> foodMap = new HashMap<>();
    static{
        for(Food food : Food.values()){
            foodMap.put(food.getName(),food);
        }
    }

    public static boolean isExistMenu(String s) {
        return foodMap.containsKey(s);
    }

    public static Food getMenuByName(String menu) {
        return foodMap.get(menu);
    }

    public static int getPriceByName(String menu) {
        return foodMap.get(menu).getPrice();
    }

    public static Category getCategoryByName(String menu) {
        return foodMap.get(menu).getCategory();
    }

    public Food getFoodByName(String name){
        return foodMap.get(name);
    }
}
