package christmas.service;

import christmas.domain.Order;
import christmas.domain.OrderManager;
import christmas.repostiroy.EventRepository;
import christmas.validator.UserInputValidator;

public class EventService {
    private final EventRepository eventRepository;
    private final int MIN = 1;
    private final int MAX = 31;
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void initDate(String dateInput) {
        UserInputValidator.validateDate(dateInput);
        int date = Integer.parseInt(dateInput);
        eventRepository.initDate(date);
    }

    public void initMenus(String menu) {
        UserInputValidator.validateMenus(menu);
        String[] split = menu.split(",");
        for(String menuInput : split){
            String[] menuInfo = menuInput.split("-");
            initMenu(menuInfo);
        }
    }

    private void initMenu(String[] menuInfo) {
        OrderManager orderManager = eventRepository.getOrderManager();
        Order order = new Order(menuInfo);
        orderManager.addOrder(order);
    }
}
