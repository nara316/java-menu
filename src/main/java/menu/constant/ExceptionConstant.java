package menu.constant;

public enum ExceptionConstant {

    ERROR_TITLE("[ERROR] "),
    INPUT_IS_ESSENTIAL("입력값은 필수입니다."),
    COACH_NAME_LENGTH_STANDARD("코치의 이름은 최소 두글자, 최대 네글자까지 입력 가능합니다."),
    COACHES_QUANTITY_STANDARD("코치들은 최소 두명, 최대 다섯명까지 함께 식사 가능합니다."),
    NONEDIBLE_QUANTITY_STANDARD("코치는 못 먹는 음식을 최대 두 개까지 입력 가능합니다.");

    private final String message;

    ExceptionConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_TITLE.message + message;
    }
}
