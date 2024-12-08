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
}
