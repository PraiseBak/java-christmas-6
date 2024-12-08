package christmas.controller;

import christmas.service.EventService;

public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    public void initDate(String date) {
        eventService.initDate(date);
    }

    public void initMenu(String menu) {
        eventService.initMenus(menu);
    }

    public String showEventResult(){
        StringBuilder stringBuilder = new StringBuilder(eventService.getOrderInfo());
        stringBuilder.append(eventService.calculatePrevPay());
        stringBuilder.append(eventService.giveFreeGift());
        stringBuilder.append(eventService.getEventApplyString());
        stringBuilder.append(eventService.getDiscountSum());
        stringBuilder.append(eventService.getAfterApplyDiscount());
        stringBuilder.append(eventService.getEventBadge());
        return stringBuilder.toString();
    }


}
