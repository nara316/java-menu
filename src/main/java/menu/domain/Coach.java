package menu.domain;

import static menu.constant.ExceptionConstant.COACH_NAME_LENGTH_STANDARD;
import static menu.constant.NumberConstant.COACH_NAME_MAX;
import static menu.constant.NumberConstant.COACH_NAME_MIN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Coach {

    private final String name;
    private final List<String> nonEdibleMenus = new ArrayList<>();

    private Coach(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public static Coach from(String name) {
        return new Coach(name);
    }

    private void validateNameLength(String name) {
        if (name.length() <= COACH_NAME_MIN.getNumber() && COACH_NAME_MAX.getNumber() <= name.length()) {
            throw new IllegalArgumentException(COACH_NAME_LENGTH_STANDARD.getMessage());
        }
    }

    public void addNonEdibleMenus(List<String> menus) {
        if (menus.equals("")) {
            return;
        }
        nonEdibleMenus.addAll(menus);
    }

    public String getName() {
        return name;
    }
}
