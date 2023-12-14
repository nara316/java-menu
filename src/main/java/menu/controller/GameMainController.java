package menu.controller;

import java.util.List;
import java.util.function.Supplier;
import menu.converter.InputConverter;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.view.InputView;
import menu.view.OutputView;

public class GameMainController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameMainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        inputView.printStartProgram();
        Coaches coaches = executeWithExceptionHandle(this::generateCoaches);
        Category category = generateCategories();
        generateNonEdibleMenus(coaches.getCoaches());
        generateRecommendMenus(coaches.getCoaches(), category.getCategories());
        outputView.printProgramResult(category.getCategories(), coaches.getCoaches());
    }

    private Coaches generateCoaches() {
        String userInput = inputView.requestCoachNames();
        return Coaches.from(InputConverter.strToList(userInput));
    }

    private void generateNonEdibleMenus(List<Coach> coaches) {
        for (Coach coach : coaches) {
            executeWithExceptionHandle(() -> {
                String userInput = inputView.requestNonEdibleMenus(coach.getName());
                coach.addNonEdibleMenus(InputConverter.strToList(userInput));
                return true;
            });
        }
    }

    private Category generateCategories() {
        Category category = Category.from();
        category.addCategories();
        return category;
    }

    private void generateRecommendMenus(List<Coach> coaches, List<String> categories) {
        for (String category : categories) {
            for (Coach coach : coaches) {
                coach.addRecommendMenus(category);
            }
        }
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
