package menu;

import java.util.List;

public class OutputView {
    void showStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    void showResult(List<Coach> coaches, List<String> categories) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.println("[ 카테고리 | " + String.join(" | ", categories) + " ]");
        for (Coach coach : coaches) {
            System.out.println("[ " + coach.getName() + " | " + String.join(" | ", coach.getMenusAlreadyEat()) + " ]");
        }
        System.out.println();
    }

    void showEnd() {
        System.out.println("추천을 완료했습니다.");
    }
}
