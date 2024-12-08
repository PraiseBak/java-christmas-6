package christmas.domain;


public enum Food{
    EPI_A("양송이 수프",5000,Category.EPI),
    EPI_B("타파스",5500,Category.EPI),
    EPI_C("시저샐러드",8000,Category.EPI),
    MAIN_A("티본스테이크",55000,Category.MAIN),
    MAIN_B("바비큐립",54000,Category.MAIN),
    MAIN_C("해산물파스타",35000,Category.MAIN),
    MAIN_D("크리스마스파스타",25000,Category.MAIN),
    SERT_A("초코케이크",15000,Category.SERT),
    SERT_B("아이스크림",5000,Category.SERT),
    BEVERAGE_A("제로콜라",3000,Category.BEVERAGE),
    BEVERAGE_B("레드와인",60000,Category.BEVERAGE),
    BEVERAGE_C("샴페인",25000,Category.BEVERAGE),
    ;
    private String name;
    private int price;
    private Category category;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    Food(String name, int price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
}
