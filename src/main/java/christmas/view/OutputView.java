package christmas.view;
public class OutputView {
    private static final String INPUT_DATE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n"
            + "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String INPUT_MENU = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public static void printError(String message) {
        println(message);
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void printInputDate() {
        println(INPUT_DATE);
    }

    public static void printInputMenu() {
        println(INPUT_MENU);
    }
}
