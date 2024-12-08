package christmas.domain;

import java.util.HashMap;
import java.util.Map;

public enum Weekend {
    FI(4,"금요일"),
    SA(5,"토요일"),
    SU(6,"일요일"),
    MO(0,"월요일"),
    TU(1,"화요일"),
    WH(2,"수요일"),
    TH(3,"목요일");

    int index;
    String day;

    Weekend(int index, String day) {
        this.index = index;
        this.day = day;
    }

    public static Weekend getCurWeekend(int date) {
        return Weekend.values()[date-1 % 7];
    }

    public boolean isOffDay() {
        return this == FI || this == SA;

    }
}
