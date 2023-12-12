package menu.controller;

import java.util.List;
import java.util.function.Supplier;
import menu.domain.Category;
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
        Category categories = Category.from();
        printRecommendResult(categories.getCategoriesLabel());
    }

    private Coaches inputCoaches() {
        return Coaches.from(inputView.inputCoachName());
    }

    private void inputNonEdibleMenus(List<Coach> coaches) {
        for (Coach coach : coaches) {
            inputView.inputNonEdibleMenu(coach.getName());
        }
    }

    private void printRecommendResult(List<String> categoriesLabel) {
        outputView.printRecommendResult(categoriesLabel);
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
