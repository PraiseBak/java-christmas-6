package christmas.repostiroy;

import christmas.domain.CalculatorManager;
import christmas.domain.CalendarManager;
import christmas.domain.OrderManager;

public class EventRepository {
    private OrderManager orderManager = new OrderManager();
    private CalendarManager calendarManager = new CalendarManager();
    private GiveProductManager giveProductManager = new GiveProductManager();
    private CalculatorManager calculatorManager = new CalculatorManager();
    private int discountMoney = 0;
    private int specialDiscount = 0;

    public CalendarManager getCalendarManager() {
        return calendarManager;
    }

    public GiveProductManager getGiveProductManager() {
        return giveProductManager;
    }

    private int date;

    public void initDate(int date) {
        this.date = date;
    }

    public OrderManager getOrderManager() {
        return orderManager;
    }

    public void initOrder() {
        orderManager = new OrderManager();
    }

    public CalculatorManager getCalculatorManager() {
        return calculatorManager;
    }

    public int getDate() {
        return date;
    }

    public void setDiscountMoney(int sum) {
        this.discountMoney = sum;
    }

    public int getDiscountMoney() {
        return discountMoney;
    }

    public void setSpecialMoney(int specialDiscount) {
        this.specialDiscount = specialDiscount;
    }

    public int getSpecialDiscount() {
        return specialDiscount;
    }
}
