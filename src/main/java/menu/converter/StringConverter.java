package menu.converter;

import java.util.Arrays;
import java.util.List;

public class StringConverter {

    private static final String DIVISION_STANDARD = ",";

    public static List<String> strToList(String userInput) {
        return Arrays.asList(userInput.split(DIVISION_STANDARD));
    }
}
