package christmas.repostiroy;

import christmas.domain.OrderManager;
import org.mockito.internal.matchers.Or;

public class EventRepository {
    private int date;
    private OrderManager orderManager = new OrderManager();
    public void initDate(int date) {
        this.date = date;
    }

    public OrderManager getOrderManager() {
        return orderManager;
    }
}
