package menu.view;

import static menu.constant.ExceptionConstant.INPUT_IS_ESSENTIAL;

import camp.nextstep.edu.missionutils.Console;
import menu.constant.ExceptionConstant;

public class InputView {

    private static final String PRINT_PROGRAM_START = "점심 메뉴 추천을 시작합니다.";
    private static final String REQUEST_COACH_NAMES = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String REQUEST_NON_EDIBLE_MENUS = "%s(이)가 못 먹는 메뉴를 입력해 주세요.\n";

    public void printStartProgram() {
        System.out.println(PRINT_PROGRAM_START);
    }

    public String requestCoachNames() {
        System.out.println(REQUEST_COACH_NAMES);
        String userInput = Console.readLine();
        validateBlank(userInput);
        return userInput;
    }

    public String requestNonEdibleMenus(String coachName) {
        System.out.printf(REQUEST_NON_EDIBLE_MENUS, coachName);
        String userInput = Console.readLine();
        return userInput;
    }

    private void validateBlank(String userInput) {
        if (userInput.isBlank()) {
            throw new IllegalArgumentException(INPUT_IS_ESSENTIAL.getMessage());
        }
    }
}
