package menu.view;

import java.util.List;

public class OutputView {
    private static final String DIVISION_STANDARD = "|";
    private static final String PRINT_RECOMMEND_RESULT = "메뉴 추천 결과입니다.\n"
            + "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String PRINT_CATEGORY_RESULT = "[ 카테고리 | %s ]";
    private static final String PRINT_RECOMMEND_END = "추천을 완료했습니다.";

    public void printRecommendResult(List<String> categories) {
        System.out.println(PRINT_RECOMMEND_RESULT);
        printCategoryResult(categories);
        System.out.println(PRINT_RECOMMEND_END);
    }

    private void printCategoryResult(List<String> categories) {
        System.out.println(String.format(PRINT_CATEGORY_RESULT, printCategories(categories)));
    }

    private String printCategories(List<String> categories) {
        return String.join(DIVISION_STANDARD, categories);
    }
}
