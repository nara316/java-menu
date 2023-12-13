package menu.domain;

import static menu.constant.ExceptionConstant.COACH_NAME_FORM_STANDARD;
import static menu.constant.ExceptionConstant.COACH_NAME_LENGTH_STANDARD;
import static menu.constant.ExceptionConstant.NONEDIBLE_QUANTITY_STANDARD;
import static menu.constant.NumberConstant.COACH_NAME_MAX;
import static menu.constant.NumberConstant.COACH_NAME_MIN;
import static menu.constant.NumberConstant.NONEDIBLE_QUANTITY_MAX;
import static menu.constant.NumberConstant.NONEDIBLE_QUANTITY_MIN;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.constant.MenuConstant;

public class Coach {

    private final String name;
    private final List<String> nonEdibleMenus = new ArrayList<>();
    private final List<String> recommendMenus = new ArrayList<>();

    private Coach(String name) {
        validateNameLength(name);
        validateNameForm(name);
        this.name = name;
    }

    public static Coach from(String name) {
        return new Coach(name);
    }

    private void validateNameLength(String name) {
        if (name.length() < COACH_NAME_MIN.getNumber() || COACH_NAME_MAX.getNumber() < name.length()) {
            throw new IllegalArgumentException(COACH_NAME_LENGTH_STANDARD.getMessage());
        }
    }

    private void validateNameForm(String name) {
        if (isNameAlphabetic(name)) {
            throw new IllegalArgumentException(COACH_NAME_FORM_STANDARD.getMessage());
        }
    }

    private boolean isNameAlphabetic(String name) {
        return !name.chars().allMatch(Character::isAlphabetic);
    }

    public void addNonEdibleMenus(List<String> nonEdibleMenus) {
        if (nonEdibleMenus.size() == 0) {
            return;
        }
        validateNonEdibleMenuInMenuConstant(nonEdibleMenus);
        validateNonEdibleMenuQuantity(nonEdibleMenus);
        this.nonEdibleMenus.addAll(nonEdibleMenus);
    }

    private void validateNonEdibleMenuInMenuConstant(List<String> nonEdibleMenus) {
        for (String menu : nonEdibleMenus) {
            if (menu.trim().length() > NONEDIBLE_QUANTITY_MIN.getNumber()) {
                MenuConstant.validateInMenus(menu);
            }
        }
    }

    private void validateNonEdibleMenuQuantity(List<String> nonEdibleMenus) {
        if (nonEdibleMenus.size() > NONEDIBLE_QUANTITY_MAX.getNumber()) {
            throw new IllegalArgumentException(NONEDIBLE_QUANTITY_STANDARD.getMessage());
        }
    }

    public boolean isValidateRecommendMenu(String menu) {
        if (nonEdibleMenus.contains(menu) || recommendMenus.contains(menu)) {
            return false;
        }
        recommendMenus.add(menu);
        return true;
    }

    public String getName() {
        return name;
    }

    public List<String> getRecommendMenus() {
        return Collections.unmodifiableList(recommendMenus);
    }
}
