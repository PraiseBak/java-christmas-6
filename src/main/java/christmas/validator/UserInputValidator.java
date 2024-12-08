package christmas.validator;

import christmas.exception.WTCEventException;
import christmas.exception.EventExceptionHelper;
import christmas.utility.NumberUtility;

public class UserInputValidator {
    public static void validateMenus(String menu) {
        String[] split = menu.split(",");
        if(split.length == 0){
            throw new WTCEventException(EventExceptionHelper.INVALID_ORDER);
        }
        for(String menuInput : split){
            String[] menuInfo = menuInput.split("-");
            if(menuInfo.length != 2){
                throw new WTCEventException(EventExceptionHelper.INVALID_ORDER);
            }
        }
    }

    public static void validateDate(String dateInput) {
        if(!NumberUtility.isNumber(dateInput)){
            throw new WTCEventException(EventExceptionHelper.INVALID_DATE);
        }
        int date = Integer.parseInt(dateInput);
        if(!(date <= MAX && date >= MIN)){
            throw new WTCEventException(EventExceptionHelper.INVALID_DATE);
        }
    }
}
