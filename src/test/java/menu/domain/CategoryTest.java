package menu.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CategoryTest {

    @Test
    void 카테고리가_생성되는지_확인() {
        Category category = Category.from();
        category.addCategories();
        System.out.println(category.getCategories());
    }
}