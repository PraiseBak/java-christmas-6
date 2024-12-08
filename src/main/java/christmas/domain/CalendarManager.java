package christmas.domain;

public class CalendarManager {
    private static final int CHRISMAS_END = 26;
    private static final String OFF_DAY_FORMAT = "주말 할인: -%,d원\n";
    private static final String DAY_FORMAT = "평일 할인: -%,d원\n";
    private static final String DDAY_EVENT_PREFIX = "크리스마스 디데이 할인: -%,d원\n";
    private static final int DISCOUNT_MONEY = 2023;
    private int discountMoney = 0;

    public String calculateDayDiscount(int date, OrderManager orderManager) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getDDayEvent(date));
        stringBuilder.append(getWeekendDayEvent(date,orderManager));
        return stringBuilder.toString();
    }

    private String getWeekendDayEvent(int date, OrderManager orderManager) {
        Weekend curWeekend = Weekend.getCurWeekend(date);
        boolean isOffDay = curWeekend.isOffDay();
        int discountMoney = orderManager.getDayEventDiscount(isOffDay) * DISCOUNT_MONEY;
        this.discountMoney += discountMoney;
        if(discountMoney == 0){
            return "";
        }
        if(isOffDay){
            return String.format(OFF_DAY_FORMAT,discountMoney);
        }
        return String.format(DAY_FORMAT,discountMoney);
    }

    private String getDDayEvent(int date) {
        int discount = 1000;
        if(date > CHRISMAS_END){
            return "";
        }
        discount += (date-1) * 100;
        discountMoney += discount;
        return String.format(DDAY_EVENT_PREFIX,discount);
    }

    public int getDiscountMoney() {
        return discountMoney;
    }
}
