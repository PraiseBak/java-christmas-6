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

    public Food getFoodByName(String name){
        return foodMap.get(name);
    }
}
