package menu.constant;

public enum NumberConstant {

    COACH_NAME_MIN(2),
    COACH_NAME_MAX(4),
    COACHES_QUANTITY_MIN(2),
    COACHES_QUANTITY_MAX(5);

    private final int number;

    NumberConstant(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
