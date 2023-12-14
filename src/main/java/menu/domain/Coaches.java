package menu.domain;

import static menu.constant.ExceptionConstant.COACHES_QUANTITY_STANDARD;
import static menu.constant.NumberConstant.COACH_QUANTITY_MAX;
import static menu.constant.NumberConstant.COACH_QUANTITY_MIN;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Coaches {

    private final List<Coach> coaches;

    private Coaches(List<String> coachNames) {
        coaches = generateCoaches(coachNames);
    }

    public static Coaches from(List<String> coachNames) {
        return new Coaches(coachNames);
    }

    private List<Coach> generateCoaches(List<String> coachNames) {
        validateCoachesQuantity(coachNames);

        return coachNames.stream()
                .map(Coach::from)
                .collect(Collectors.toList());
    }

    private void validateCoachesQuantity(List<String> coachNames) {
        if (coachNames.size() < COACH_QUANTITY_MIN.getNumber() || coachNames.size() > COACH_QUANTITY_MAX.getNumber()) {
            throw new IllegalArgumentException(COACHES_QUANTITY_STANDARD.getMessage());
        }
    }

    public List<Coach> getCoaches() {
        return Collections.unmodifiableList(coaches);
    }
}
