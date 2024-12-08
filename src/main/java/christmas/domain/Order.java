package christmas.domain;

import christmas.exception.WTCEventException;
import christmas.exception.EventExceptionHelper;
import christmas.utility.NumberUtility;

public class Order {
    private final int request;
    private final String menu;
    public Order(String[] menuInfo){
        validateOrder(menuInfo);
        menu = menuInfo[0];
        request = Integer.parseInt(menuInfo[1]);
    }

    private void validateOrder(String[] menuInfo) {
        if(!FoodRepository.isExistMenu(menuInfo[0])){
            throw new WTCEventException(EventExceptionHelper.INVALID_ORDER);
        }
        if(!NumberUtility.isNumber(menuInfo[1]) || !NumberUtility.isPositive(Integer.parseInt(menuInfo[1]))){
            throw new WTCEventException(EventExceptionHelper.INVALID_ORDER);
        }
    }

    public String getMenu() {
        return menu;
    }

    public int getPayPrice() {
        return request * FoodRepository.getPriceByName(menu);
    }

    public String getOrderInfo(){
        return menu + " " + request + "개";
    }

    public boolean isSameCategory(Category category) {
        Category menuCategory = FoodRepository.getCategoryByName(menu);
        return category == menuCategory;
    }

    public int sameCategoryCount(Category category) {
        if(isSameCategory(category)){
            return request;
        }
        return 0;
    }
}
