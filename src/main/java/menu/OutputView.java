package menu;

import java.util.List;

public class OutputView {

    public static final String START = "점심 메뉴 추천을 시작합니다.";
    public static final String END = "추천을 완료했습니다.";
    public static final String RESULT_START = "메뉴 추천 결과입니다.";
    public static final String DIVISION = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    public static final String DELIMITER = " | ";
    public static final String START_MENU = "[ ";
    public static final String END_MENU = " ]";
    public static final String START_CATEGORY = "[ 카테고리 | ";
    public static final String END_CATEGORY = " ]";

    void showStart() {
        System.out.println(START);
    }

    void showResult(List<Coach> coaches, List<String> categories) {
        System.out.println(RESULT_START);
        System.out.println(DIVISION);
        System.out.println(START_CATEGORY + String.join(DELIMITER, categories) + END_CATEGORY);
        for (Coach coach : coaches) {
            System.out.print(START_MENU + coach.getName() + DELIMITER);
            System.out.println(String.join(DELIMITER, coach.getMenusAlreadyEat()) + END_MENU);
        }
        System.out.println();
    }

    void showEnd() {
        System.out.println(END);
    }
}
