package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MenuSuggestion {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    List<Coach> coaches = new ArrayList<Coach>();

    void play() {
        setup();
    }

    void setup() {
        outputView.showStart();
        setupCoaches();
    }

    void setupCoaches() {
        List<String> names = inputView.readNames();
        for (String name : names) {
            setupCoachCantEat(name);
        }
    }

    void setupCoachCantEat(String name) {
        Coach coach = new Coach(name);
        List<String> menus = inputView.readMenus(name);
        if (menus.size() == 1 && Objects.equals(menus.get(0), "")) {
            coaches.add(coach);
            return;
        }
        for (String menu : menus) {
            coach.setMenus(menu);
        }
        coaches.add(coach);
    }
}
