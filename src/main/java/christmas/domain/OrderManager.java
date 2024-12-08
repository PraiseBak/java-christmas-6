package christmas.domain;

import christmas.exception.WTCEventException;
import christmas.exception.EventExceptionHelper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderManager {
    private final Set<String> orderFoodSet = new HashSet<>();
    private final List<Order> orders = new ArrayList<>();
    public void addOrder(Order order) {
        if(orderFoodSet.contains(order.getMenu())){
            throw new WTCEventException(EventExceptionHelper.INVALID_ORDER);
        }
        orders.add(order);
    }
}
