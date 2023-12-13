package menu.constant;

public enum ExceptionConstant {

    ERROR_TITLE("[ERROR] "),
    INPUT_IS_ESSENTIAL("입력값은 필수입니다."),
    COACH_NAME_LENGTH_STANDARD("코치의 이름은 2자리 이상 4자리 이하 입니다."),
    COACH_NAME_FORM_STANDARD("코치의 이름은 문자만 허용합니다."),
    COACHES_QUANTITY_STANDARD("코치들은 최소 2명, 최대 5명까지 함께 식사할 수 있습니다."),
    COACHES_CANNOT_DUPLICATED("코치들의 이름은 중복될 수 없습니다"),
    NONEDIBlE_MENU_STANDARD("메뉴 리스트에 없는 음식은 입력할 수 없습니다."),
    NONEDIBLE_QUANTITY_STANDARD("못 먹는 음식은 최대 2개까지 입력 가능합니다.");

    private final String message;

    ExceptionConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_TITLE.message + message;
    }
}
