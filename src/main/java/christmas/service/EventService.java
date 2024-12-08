package christmas.service;

import christmas.exception.EventException;
import christmas.repostiroy.EventRepository;
import christmas.utility.NumberUtility;

public class EventService {

    private final EventRepository eventRepository;
    private final String INVALID_DATE = "유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private final int MIN = 1;
    private final int MAX = 31;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void initDate(String dateInput) {
        if(!NumberUtility.isNumber(dateInput)){
            throw new EventException(INVALID_DATE);
        }
        int date = Integer.parseInt(dateInput);
        if(!(date <= MAX && date >= MIN)){
            throw new EventException(INVALID_DATE);
        }
        eventRepository.initDate(date);
    }
}
