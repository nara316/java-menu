package menu.domain;

import static menu.constant.ExceptionConstant.COACH_NAME_LENGTH_STANDARD;
import static menu.constant.ExceptionConstant.NONEDIBLE_QUANTITY_STANDARD;
import static menu.constant.NumberConstant.COACH_NAME_MAX;
import static menu.constant.NumberConstant.COACH_NAME_MIN;
import static menu.constant.NumberConstant.NON_EDIBLE_MAX;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.constant.MenuConstant;

public class Coach {

    private final String name;
    private List<String> nonEdibleMenus;
    private List<String> recommendMenus;

    private Coach(String name) {
        validateNameLength(name);
        this.name = name;
        nonEdibleMenus = new ArrayList<>();
        recommendMenus = new ArrayList<>();
    }

    public static Coach from(String name) {
        return new Coach(name);
    }

    private void validateNameLength(String name) {
        if (name.length() < COACH_NAME_MIN.getNumber() || name.length() > COACH_NAME_MAX.getNumber()) {
            throw new IllegalArgumentException(COACH_NAME_LENGTH_STANDARD.getMessage());
        }
    }

    public void addNonEdibleMenus(List<String> nonEdibleMenus) {
        if (nonEdibleMenus.size() == 0) {
            return;
        }
        validateNonEdibleMenusQuantity(nonEdibleMenus);
        this.nonEdibleMenus.addAll(nonEdibleMenus);
    }

    private void validateNonEdibleMenusQuantity(List<String> nonEdibleMenus) {
        if (nonEdibleMenus.size() > NON_EDIBLE_MAX.getNumber()) {
            throw new IllegalArgumentException(NONEDIBLE_QUANTITY_STANDARD.getMessage());
        }
    }

    public void addRecommendMenus(String category) {
            while (true) {
                List<String> menus = MenuConstant.generateMenusByCategory(category);
                String recommendMenu = generateRecommendMenu(menus);
                if (checkRecommendQualified(recommendMenu)) {
                    break;
                }
            }
    }

    private boolean checkRecommendQualified(String recommendMenu) {
        if (recommendMenus.contains(recommendMenu) || nonEdibleMenus.contains(recommendMenu)) {
            return false;
        }
        recommendMenus.add(recommendMenu);
        return true;
    }

    private String generateRecommendMenu(List<String> menus) {
        return Randoms.shuffle(menus).get(0);
    }

    public String getName() {
        return name;
    }

    public List<String> getRecommendMenus() {
        return Collections.unmodifiableList(recommendMenus);
    }
}
