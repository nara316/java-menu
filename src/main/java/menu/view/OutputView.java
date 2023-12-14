package menu.view;

import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;

public class OutputView {

    private static final String PRINT_STANDARD = " | ";
    private static final String PRINT_PROGRAM_RESULT = "메뉴 추천 결과입니다.\n"+
            "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String PRINT_RECOMMEND_CATEGORIES = "[ 카테고리 | %s ]";
    private static final String PRINT_RECOMMEND_MENUS = "[ %s | %s ]";
    private static final String PRINT_PROGRAM_END = "추천을 완료했습니다.";

    public void printProgramResult(List<String> categories, List<Coach> coaches) {
        System.out.println(PRINT_PROGRAM_RESULT);
        printCategoryResult(categories);
        printRecommendMenus(coaches);
        System.out.println(PRINT_PROGRAM_END);
    }

    private void printCategoryResult(List<String> categories) {
        System.out.println(String.format(PRINT_RECOMMEND_CATEGORIES, printResult(categories)));
    }

    private void printRecommendMenus(List<Coach> coaches) {
        for (Coach coach : coaches) {
            System.out.println(String.format(PRINT_RECOMMEND_MENUS,
                    coach.getName(), printResult(coach.getRecommendMenus())));
        }
    }

    private String printResult(List<String> result) {
        return String.join(PRINT_STANDARD, result);
    }
}
