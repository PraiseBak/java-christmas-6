package christmas.utility;

import java.util.regex.Pattern;

public class NumberUtility {

    private final static String IS_NUMBER_REGEX = "^[0-9]+$";

    public static boolean isNumber(String leftMoney) {
        return Pattern.matches(IS_NUMBER_REGEX,leftMoney);
    }

    public static boolean isPositive(int leftMoney) {
        if(leftMoney >= 1){
            return true;
        }
        return false;
    }
}
