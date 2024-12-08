package christmas.domain;

public enum Category {
    EPI("에피타이저"),
    MAIN("메인"),
    SERT("디저트"),
    BEVERAGE("음료");

    private final String category;

    public String getCategory() {
        return category;
    }

    Category(String category) {
        this.category = category;
    }
}
