package menu.view;

import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;

public class OutputView {
    private static final String DIVISION_STANDARD = " | ";
    private static final String PRINT_RECOMMEND_RESULT = "메뉴 추천 결과입니다.\n"
            + "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String PRINT_CATEGORY_RESULT = "[ 카테고리 | %s ]";
    private static final String PRINT_MENU_RESULT = "[ %s | %s ]";
    private static final String PRINT_RECOMMEND_END = "추천을 완료했습니다.";

    public void printRecommendResult(List<String> categories, Coaches coaches) {
        System.out.println(PRINT_RECOMMEND_RESULT);
        printCategoryResult(categories);
        printMenuResult(coaches);
        System.out.println(PRINT_RECOMMEND_END);
    }

    private void printCategoryResult(List<String> categories) {
        System.out.println(String.format(PRINT_CATEGORY_RESULT, printCategories(categories)));
    }

    private void printMenuResult(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            System.out.println(String.format(PRINT_MENU_RESULT,
                    coach.getName(), printCategories(coach.getRecommendMenus())));
        }
    }

    private String printCategories(List<String> result) {
        return String.join(DIVISION_STANDARD, result);
    }
}
