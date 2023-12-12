package menu.constant;

import java.util.Arrays;

public enum CategoryConstant {

    JAPAN(1, "일식"),
    KOREA(2, "한식"),
    CHINA(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식");

    private final int number;
    private final String label;

    CategoryConstant(int number, String label) {
        this.number = number;
        this.label = label;
    }

    public static CategoryConstant calculateCategory(int randomNumber) {
        return Arrays.stream(CategoryConstant.values())
                .filter(categoryConstant -> randomNumber == categoryConstant.number)
                .findFirst()
                .orElseThrow();
    }
}

