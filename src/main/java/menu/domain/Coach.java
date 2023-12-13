package menu.domain;

import static menu.constant.ExceptionConstant.COACH_NAME_FORM_STANDARD;
import static menu.constant.ExceptionConstant.COACH_NAME_LENGTH_STANDARD;
import static menu.constant.NumberConstant.COACH_NAME_MAX;
import static menu.constant.NumberConstant.COACH_NAME_MIN;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public void addNonEdibleMenus(List<String> menus) {
        if (menus.isEmpty()) {
            nonEdibleMenus.add("");
        }
        nonEdibleMenus.addAll(menus);
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
