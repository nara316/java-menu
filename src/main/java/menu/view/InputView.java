package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String PRINT_RECOMMEND_START = "점심 메뉴 추천을 시작합니다.";
    private static final String REQUEST_COACHES_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String REQUEST_NON_EDIBLE_MENU = "%s(이)가 못 먹는 메뉴를 입력해 주세요.\n";

    public void printProgramStart() {
        System.out.println(PRINT_RECOMMEND_START);
    }

    public String inputCoachName() {
        System.out.println(REQUEST_COACHES_NAME);
        String userInput = Console.readLine();
        return userInput;
    }
}
