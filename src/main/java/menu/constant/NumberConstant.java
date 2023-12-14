package menu.constant;

public enum NumberConstant {

    COACH_NAME_MIN(2),
    COACH_NAME_MAX(4),
    COACH_QUANTITY_MIN(2),
    COACH_QUANTITY_MAX(5),
    NON_EDIBLE_MAX(2),
    CATEGORY_MAX(5),
    CATEGORY_DUPLICATE_MAX(2);

    private final int number;

    NumberConstant(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
