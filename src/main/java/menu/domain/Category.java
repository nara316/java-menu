package menu.domain;

import static menu.constant.NumberConstant.CATEGORY_DUPLICATE_MAX;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.constant.MenuConstant;
import menu.constant.NumberConstant;

public class Category {

    private List<MenuConstant> categories;

    private Category() {
        categories = new ArrayList<>();
    }

    public static Category from() {
        return new Category();
    }

    public List<MenuConstant> addCategories() {
        while (categories.size() < NumberConstant.CATEGORY_MAX.getNumber()) {
            MenuConstant menuConstant = MenuConstant.generateCategoryByNumber(generateRandomNumber());
            if (isValidateCategoryDuplicated(menuConstant)) {
                continue;
            }
            categories.add(menuConstant);
        }
        return categories;
    }

    private boolean isValidateCategoryDuplicated(MenuConstant menuConstant) {
        return categories.stream().filter(categoryConstant -> categoryConstant.equals(menuConstant))
                .count() >= CATEGORY_DUPLICATE_MAX.getNumber();
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(1, 5);
    }

    public List<String> getCategories() {
        return categories.stream()
                .map(MenuConstant::getCategory)
                .collect(Collectors.toList());
    }
}
