package christmas.domain;

import christmas.exception.WTCEventException;
import christmas.exception.EventExceptionHelper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderManager {
    private final Set<String> orderFoodSet = new HashSet<>();
    private final List<Order> orders = new ArrayList<>();
    private String ORDER_INFO_PREFIX = "<주문 메뉴>\n";

    public void addOrder(Order order) {
        if(orderFoodSet.contains(order.getMenu())){
            throw new WTCEventException(EventExceptionHelper.INVALID_ORDER);
        }
        orders.add(order);
    }

    public void validateOrders() {
        boolean isNonBeverExists = false;
        for(Order order : orders){
            String menu = order.getMenu();
            Food food = FoodRepository.getMenuByName(menu);
            if(food.getCategory() != Category.BEVERAGE){
                isNonBeverExists = true;
            }
        }
        if(!isNonBeverExists){
            throw new WTCEventException(EventExceptionHelper.INVALID_ORDER);
        }
    }

    public int calculatePrevPay() {
        return orders.stream()
                .mapToInt(o -> o.getPayPrice())
                .sum();
    }

    public String getOrderInfo() {
        StringBuilder stringBuilder = new StringBuilder(ORDER_INFO_PREFIX);
        String collect = orders.stream()
                .map((o) -> o.getOrderInfo())
                .collect(Collectors.joining("\n"));
        stringBuilder.append(collect).append("\n");
        return stringBuilder.toString();
    }

    public int getDayEventDiscount(boolean isOffDay) {
        Category category = Category.SERT;
        if(isOffDay){
            category = Category.MAIN;
        }
        int count = 0;
        for(Order order : orders){
            count += order.sameCategoryCount(category);
        }
        return count;
    }

}
