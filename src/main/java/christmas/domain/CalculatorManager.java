package christmas.domain;

public class CalculatorManager {
    private int prevPayPrice = 0;

    public String calculatePrevPay(OrderManager orderManager) {
        prevPayPrice = orderManager.calculatePrevPay();
        return CalculateFormatter.getPrevPayResult(prevPayPrice);
    }

    public int getCalculatePrevPay() {
        return prevPayPrice;
    }

    public String getBadge(int discountMoney) {
        if(discountMoney >= 20000){
            return "산타";
        }
        if(discountMoney >= 10000){
            return "트리";
        }
        if(discountMoney >= 5000){
            return "별";
        }
        return "없음";
    }
}
