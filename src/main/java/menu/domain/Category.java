package menu.domain;

import static menu.constant.CategoryConstant.calculateCategory;
import static menu.constant.NumberConstant.CATEGORY_DUPLICATED_STANDARD;
import static menu.constant.NumberConstant.CATEGORY_NUMBER_MAX;
import static menu.constant.NumberConstant.CATEGORY_NUMBER_MIN;
import static menu.constant.NumberConstant.CATEGORY_SIZE_MAX;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.constant.CategoryConstant;

public class Category {

    private final List<CategoryConstant> categories;

    private Category() {
        this.categories = generateCategory();
    }

    public static Category from() {
        return new Category();
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
                .count() > CATEGORY_DUPLICATED_STANDARD.getNumber();
    }
}
