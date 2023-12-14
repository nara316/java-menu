package menu;

import menu.controller.GameMainController;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameMainController gameMainController = new GameMainController(
                new InputView(),
                new OutputView());

        gameMainController.run();
    }
}
