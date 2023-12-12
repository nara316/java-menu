package menu.view;

public class OutputView {
    private static final String PRINT_RECOMMEND_RESULT = "메뉴 추천 결과입니다.\n"
            + "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String PRINT_RECOMMEND_END = "추천을 완료했습니다.";

    public void printRecommendResult() {
        System.out.println(PRINT_RECOMMEND_RESULT);
        System.out.println(PRINT_RECOMMEND_END);
    }
}
