package menu.controller;

import java.util.List;
import java.util.function.Supplier;
import menu.domain.MenuRecommendator;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.view.InputView;
import menu.view.OutputView;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;

    public MainController(
            InputView inputView, OutputView outputView
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        inputView.printProgramStart();
        Coaches coaches = executeWithExceptionHandle(this::inputCoaches);
        inputNonEdibleMenus(coaches.getCoaches());
        MenuRecommendator menuRecommendator = MenuRecommendator.from();
        menuRecommendator.recommendMenus(coaches);
        printRecommendResult(menuRecommendator.getCategoriesLabel(), coaches);
    }

    private Coaches inputCoaches() {
        return Coaches.from(inputView.inputCoachName());
    }

    private void inputNonEdibleMenus(List<Coach> coaches) {
//        for (Coach coach : coaches) {
//            List<String> nonEdibleMenus = inputView.inputNonEdibleMenu(coach.getName());
//            coach.addNonEdibleMenus(nonEdibleMenus);
//        }

        for (Coach coach : coaches) {
            executeWithExceptionHandle(() -> {
                List<String> nonEdibleMenus = inputView.inputNonEdibleMenu(coach.getName());
                coach.addNonEdibleMenus(nonEdibleMenus);
                return true;
            });
        }
    }

    private void printRecommendResult(List<String> categoriesLabel, Coaches coaches) {
        outputView.printRecommendResult(categoriesLabel, coaches);
    }

    private static <T> T executeWithExceptionHandle (final Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
