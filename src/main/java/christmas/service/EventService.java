package christmas.service;

import christmas.domain.CalculatorManager;
import christmas.domain.CalendarManager;
import christmas.domain.Order;
import christmas.domain.OrderManager;
import christmas.repostiroy.EventRepository;
import christmas.repostiroy.GiveProductManager;
import christmas.validator.UserInputValidator;

public class EventService {
    private static final String EVENT_BADGE_PREFIX = "\n<12월 이벤트 배지>\n";
    private static final String AFTER_APPLY_DISCOUNT = "\n<할인 후 예상 결제 금액>\n";
    private static final String AFTER_APPLY_FORMAT = "%,d원\n";
    private static final String AFTER_APPLY_FORMAT_MINUS = "-%,d원\n";
    private static final String SPECIAL_EVENT_FORMAT = "특별 할인: -%,d원";
    private static final String DISCOUNT_PREFIX = "\n<혜택 내역>\n";
    private static final String EMPTY = "없음";
    private static final int MIN_SPECIAL_EVENT = 5000;
    private static final int SPECIAL_DISCOUNT = 1000;
    private static final String AFTER_APPLY_PREFIX = "\n\n<총혜택 금액>\n";
    private final EventRepository eventRepository;
    private int EVENT_APPLY_MIN = 10000;


    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void initDate(String dateInput) {
        UserInputValidator.validateDate(dateInput);
        int date = Integer.parseInt(dateInput);
        eventRepository.initDate(date);
    }

    public void initMenus(String menu) {
        eventRepository.initOrder();
        OrderManager orderManager = eventRepository.getOrderManager();
        UserInputValidator.validateMenus(menu);
        String[] split = menu.split(",");
        for(String menuInput : split){
            String[] menuInfo = menuInput.split("-");
            initMenu(menuInfo);
        }
        orderManager.validateOrders();
    }

    private void initMenu(String[] menuInfo) {
        Order order = new Order(menuInfo);
        OrderManager orderManager = eventRepository.getOrderManager();
        orderManager.addOrder(order);
    }


    public String calculatePrevPay() {
        OrderManager orderManager = eventRepository.getOrderManager();
        CalculatorManager calculatorManager = eventRepository.getCalculatorManager();
        return calculatorManager.calculatePrevPay(orderManager);
    }

    public String getOrderInfo() {
        OrderManager orderManager = eventRepository.getOrderManager();
        return orderManager.getOrderInfo();
    }

    public String giveFreeGift() {
        GiveProductManager giveProductManager = eventRepository.getGiveProductManager();
        int calculatePrevPay = eventRepository.getCalculatorManager().getCalculatePrevPay();
        return giveProductManager.calculateFreeGive(calculatePrevPay);
    }

    public String getDiscountSummery() {
        StringBuilder stringBuilder = new StringBuilder(DISCOUNT_PREFIX);
        CalendarManager calendarManager = eventRepository.getCalendarManager();
        OrderManager orderManager = eventRepository.getOrderManager();
        int date = eventRepository.getDate();
        return getDiscountSummeryString(stringBuilder, calendarManager, date, orderManager);
    }

    private String getDiscountSummeryString(StringBuilder stringBuilder, CalendarManager calendarManager, int date,
                             OrderManager orderManager) {
        stringBuilder.append(calendarManager.calculateDayDiscount(date, orderManager));
        stringBuilder.append(eventRepository.getGiveProductManager().getFreeGivePriceResult());
        stringBuilder.append(getSpecialEvent());
        if(stringBuilder.toString().isEmpty()){
            return EMPTY;
        }
        return stringBuilder.toString();
    }

    private String getSpecialEvent(){
        CalendarManager calendarManager = eventRepository.getCalendarManager();
        GiveProductManager giveProductManager = eventRepository.getGiveProductManager();
        int sum = calendarManager.getDiscountMoney() + giveProductManager.getFreeGivePrice();;
        eventRepository.setDiscountMoney(sum);
        if(sum >= MIN_SPECIAL_EVENT){
            eventRepository.setSpecialMoney(SPECIAL_DISCOUNT);
        }
        if(sum != 0){
            return String.format(SPECIAL_EVENT_FORMAT, SPECIAL_DISCOUNT);
        }
        return "";
    }

    public String getDiscountSum() {
        StringBuilder stringBuilder = new StringBuilder(AFTER_APPLY_PREFIX);
        int discountMoney = eventRepository.getDiscountMoney();
        int specialMoney = eventRepository.getSpecialDiscount();
        if(discountMoney + specialMoney == 0){
            stringBuilder.append(String.format(AFTER_APPLY_FORMAT,discountMoney + specialMoney));
            return stringBuilder.toString();
        }
        stringBuilder.append(String.format(AFTER_APPLY_FORMAT_MINUS,discountMoney + specialMoney));
        return stringBuilder.toString();
    }

    public String getAfterApplyDiscount() {
        CalculatorManager calculatorManager = eventRepository.getCalculatorManager();
        GiveProductManager giveProductManager = eventRepository.getGiveProductManager();
        int calculatePrevPay = calculatorManager.getCalculatePrevPay();
        int discountMoney = eventRepository.getDiscountMoney();
        return AFTER_APPLY_DISCOUNT + String.format(AFTER_APPLY_FORMAT,(calculatePrevPay-discountMoney- eventRepository.getSpecialDiscount() + giveProductManager.getFreeGivePrice()));
    }

    public String getEventBadge() {
        StringBuilder stringBuilder = new StringBuilder(EVENT_BADGE_PREFIX);
        int discountMoney = eventRepository.getDiscountMoney();
        CalculatorManager calculatorManager = eventRepository.getCalculatorManager();
        String badge = calculatorManager.getBadge(discountMoney);
        return stringBuilder.append(badge).toString();
    }

    public boolean isEventApply() {
        return eventRepository.getCalculatorManager().getCalculatePrevPay() >= EVENT_APPLY_MIN;
    }

    public String getEventApplyString() {
        StringBuilder stringBuilder = new StringBuilder();
        if(isEventApply()){
            stringBuilder.append(getDiscountSummery());
        }
        if(!isEventApply()){
            stringBuilder.append("\n<혜택 내역>\n" + "없음");
        }
        return stringBuilder.toString();
    }
}


