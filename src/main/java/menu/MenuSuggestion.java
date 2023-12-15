package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class MenuSuggestion {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private List<Coach> coaches = new ArrayList<Coach>();
    private List<String> categories = new ArrayList<>();

    void play() {
        setup();
        for (int i = 0; i < 5; i++) {
            doSuggestion();
        }
        printResult();
    }

    private void setup() {
        outputView.showStart();
        setupCoaches();
    }

    private void setupCoaches() {
        List<String> names = inputView.readNames();
        for (String name : names) {
            setupCoachCantEat(name);
        }
    }

    private void setupCoachCantEat(String name) {
        Coach coach = new Coach(name);
        List<String> menus = inputView.readMenus(name);
        if (menus.size() == 1 && Objects.equals(menus.get(0), "")) {
            coaches.add(coach);
            return;
        }
        for (String menu : menus) {
            coach.setMenusCantEat(menu);
        }
        coaches.add(coach);
    }

    private void doSuggestion() {
        Menu category = pickCategory();
        for (Coach coach : coaches) {
            pickMenu(coach, category);
        }
    }

    private Menu pickCategory() {
        while (true) {
            Menu category = Menu.getCategoryFromValue(Randoms.pickNumberInRange(1, 5));
            if (Collections.frequency(categories, category.getKoreanName()) >= 2 ) {
                continue;
            }
            categories.add(category.getKoreanName());
            return category;
        }
    }

    private void pickMenu(Coach coach, Menu category) {
        while (true) {
            String menu = Randoms.shuffle(category.getMenus()).get(0);
            if (!coach.isPossibleMenu(menu)) {
                continue;
            }
            coach.setMenusAlreadyEat(menu);
            return;
        }
    }

    private void printResult() {
        outputView.showResult(coaches, categories);
        outputView.showEnd();
    }
}
