package menu.domain;

import static menu.constant.CategoryConstant.calculateCategory;
import static menu.constant.MenuConstant.calculateMenu;
import static menu.constant.NumberConstant.CATEGORY_DUPLICATED_STANDARD;
import static menu.constant.NumberConstant.CATEGORY_NUMBER_MAX;
import static menu.constant.NumberConstant.CATEGORY_NUMBER_MIN;
import static menu.constant.NumberConstant.CATEGORY_SIZE_MAX;
import static menu.constant.NumberConstant.RECOMMEND_MENU_STANDARD;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.constant.CategoryConstant;

public class MenuRecommendator {

    private final List<CategoryConstant> categories = new ArrayList<>();

    private MenuRecommendator() {
        generateCategory();
    }

    public static MenuRecommendator from() {
        return new MenuRecommendator();
    }

    private List<CategoryConstant> generateCategory() {
        while (categories.size() < CATEGORY_SIZE_MAX.getNumber()) {
            CategoryConstant newCategory = calculateCategory(pickRandomNumber());
            if (validateCategoryDuplicated(newCategory)) {
                continue;
            }
            categories.add(newCategory);
        }
        return categories;
    }

    private int pickRandomNumber() {
        return Randoms.pickNumberInRange(CATEGORY_NUMBER_MIN.getNumber(), CATEGORY_NUMBER_MAX.getNumber());
    }

    private boolean validateCategoryDuplicated(CategoryConstant newCategory) {
        return categories.stream().filter(categoryConstant -> categoryConstant.equals(newCategory))
                .count() >= CATEGORY_DUPLICATED_STANDARD.getNumber();
    }

    public void recommendMenus(Coaches coaches) {
        for (CategoryConstant categoryConstant : categories) {
            for (Coach coach : coaches.getCoaches()) {
                selectMenu(coach, categoryConstant);
            }
        }
    }

    private void selectMenu(Coach coach, CategoryConstant categoryConstant) {
        while (true) {
            String selectMenu = Randoms.shuffle(calculateMenu(categoryConstant).getMenus())
                    .get(RECOMMEND_MENU_STANDARD.getNumber());
            if (coach.isValidateRecommendMenu(selectMenu)) {
                break;
            }
        }
    }

    public List<String> getCategoriesLabel() {
        return categories.stream()
                .map(CategoryConstant::getLabel)
                .collect(Collectors.toList());
    }
}
