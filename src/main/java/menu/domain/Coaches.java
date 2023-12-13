package menu.domain;

import static menu.constant.ExceptionConstant.COACHES_QUANTITY_STANDARD;
import static menu.constant.NumberConstant.COACHES_QUANTITY_MAX;
import static menu.constant.NumberConstant.COACHES_QUANTITY_MIN;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Coaches {

    private final List<Coach> coaches;

    private Coaches(List<String> names) {
        this.coaches = generateCoaches(names);
    }

    public static Coaches from(List<String> names) {
        return new Coaches(names);
    }

    private List<Coach> generateCoaches(List<String> names) {
        validateCoachesQuantity(names);

        return names.stream()
                .map(Coach::from)
                .collect(Collectors.toList());
    }

    private void validateCoachesQuantity(List<String> names) {
        if (names.size() < COACHES_QUANTITY_MIN.getNumber() || COACHES_QUANTITY_MAX.getNumber() < names.size()) {
            throw new IllegalArgumentException(COACHES_QUANTITY_STANDARD.getMessage());
        }
    }

    public List<Coach> getCoaches() {
        return Collections.unmodifiableList(coaches);
    }
}
