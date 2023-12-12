package menu.view;

import static menu.constant.ExceptionConstant.INPUT_IS_ESSENTIAL;
import static menu.converter.StringConverter.strToList;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    private static final String PRINT_RECOMMEND_START = "점심 메뉴 추천을 시작합니다.";
    private static final String REQUEST_COACHES_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String REQUEST_NON_EDIBLE_MENU = "%s(이)가 못 먹는 메뉴를 입력해 주세요.\n";

    public void printProgramStart() {
        System.out.println(PRINT_RECOMMEND_START);
    }

    public List<String> inputCoachName() {
        System.out.println(REQUEST_COACHES_NAME);
        String userInput = Console.readLine();
        validateBlank(userInput);
        return strToList(userInput);
    }

    public List<String> inputNonEdibleMenu(String coachName) {
        System.out.printf(REQUEST_NON_EDIBLE_MENU, coachName);
        String userInput = Console.readLine();
        return strToList(userInput);
    }

    private void validateBlank(String userInput) {
        if (userInput.isBlank()) {
            throw new IllegalArgumentException(INPUT_IS_ESSENTIAL.getMessage());
        }
    }
}
