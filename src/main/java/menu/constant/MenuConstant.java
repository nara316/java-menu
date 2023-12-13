package menu.constant;

import static menu.constant.ExceptionConstant.NONEDIBlE_MENU_STANDARD;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum MenuConstant {

    JAPAN(CategoryConstant.JAPAN, Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREA(CategoryConstant.KOREA, Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINA(CategoryConstant.CHINA, Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN(CategoryConstant.ASIAN, Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WESTERN(CategoryConstant.WESTERN, Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    private final CategoryConstant categoryConstant;
    private final List<String> menus;

    MenuConstant(CategoryConstant categoryConstant, List<String> menus) {
        this.categoryConstant = categoryConstant;
        this.menus = menus;
    }

    public static MenuConstant calculateMenu(CategoryConstant categoryConstant) {
        return Arrays.stream(MenuConstant.values())
                .filter(menuConstant -> menuConstant.categoryConstant.equals(categoryConstant))
                .findFirst()
                .orElseThrow();
    }

    public static void validateInMenus(String nonEdibleMenu) {
        Arrays.stream(MenuConstant.values())
                .filter(menuConstant -> menuConstant.menus.contains(nonEdibleMenu))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NONEDIBlE_MENU_STANDARD.getMessage()));
    }

    public List<String> getMenus() {
        return Collections.unmodifiableList(menus);
    }
}
