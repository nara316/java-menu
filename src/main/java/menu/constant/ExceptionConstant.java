package menu.constant;

public enum ExceptionConstant {

    ERROR_TITLE("[ERROR] "),
    INPUT_IS_ESSENTIAL("입력값은 필수입니다."),
    COACH_NAME_LENGTH_STANDARD("코치의 이름은 2자리 이상 4자리 이하 입니다.");

    private final String message;

    ExceptionConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_TITLE.message + message;
    }
}
