package christmas.domain;

public class CalculateFormatter {


    private static final String PREV_PAY_PREFIX = "\n<할인 전 총주문 금액>\n";
    private static final String PREV_PAY_FORMAT = "%,d원";

    public static String getPrevPayResult(int prevPayPrice) {
        StringBuilder stringBuilder = new StringBuilder(PREV_PAY_PREFIX);
        stringBuilder.append(String.format(PREV_PAY_FORMAT,prevPayPrice));
        return stringBuilder.toString();
    }
}
