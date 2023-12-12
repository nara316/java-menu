package menu.domain;

import static menu.constant.ExceptionConstant.COACH_NAME_LENGTH_STANDARD;
import static menu.constant.NumberConstant.COACH_NAME_MAX;
import static menu.constant.NumberConstant.COACH_NAME_MIN;

public class Coach {

    private final String name;

    private Coach(String name) {
        this.name = name;
    }

    public static Coach from(String name) {
        return new Coach(name);
    }

    private void validateNameLength(String name) {
        if (COACH_NAME_MIN.getNumber() <= name.length() && name.length() <= COACH_NAME_MAX.getNumber()) {
            throw new IllegalArgumentException(COACH_NAME_LENGTH_STANDARD.getMessage());
        }
    }
}
