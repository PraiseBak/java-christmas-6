package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String readLine(){
        return Console.readLine();
    }

    public static String inputDate() {
        OutputView.printInputDate();
        return readLine();
    }
}
