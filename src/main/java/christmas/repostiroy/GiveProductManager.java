package christmas.repostiroy;

import christmas.domain.FoodRepository;

public class GiveProductManager {
    private static final String GIVE_PRODUCT_PREFIX = "\n\n<증정 메뉴>\n";
    private static final String FREE_GIVE_PRICE_FORMAT = "증정 이벤트: -%,d원\n";
    private String FREE_FOOD = "샴페인";

    private int freeGivePrice = 0;
    private int freeGiveCount = 0;

    public String calculateFreeGive(int calculatePrevPay) {
        StringBuilder stringBuilder = new StringBuilder(GIVE_PRODUCT_PREFIX);
        if(calculatePrevPay >= 120000){
            freeGivePrice += FoodRepository.getPriceByName(FREE_FOOD);
            freeGiveCount++;
            stringBuilder.append(FREE_FOOD + " " + freeGiveCount + "개");
        }
        if(freeGiveCount == 0){
            stringBuilder.append("없음\n");
        }
        return stringBuilder.toString();
    }

    public String getFreeGivePriceResult() {
        return String.format(FREE_GIVE_PRICE_FORMAT,freeGivePrice);
    }

    public int getFreeGivePrice() {
        return freeGivePrice;
    }
}
