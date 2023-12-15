package menu;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    List<String> menusCantEat = new ArrayList<>();
    List<String> menusAlreadyEat = new ArrayList<>();

    Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getMenusAlreadyEat() {
        return menusAlreadyEat;
    }

    void setMenusCantEat(String menu) {
        menusCantEat.add(menu);
    }

    void setMenusAlreadyEat(String menu) {
        menusAlreadyEat.add(menu);
    }

    boolean isPossibleMenu(String menu) {
        if (menusCantEat.contains(menu) || menusAlreadyEat.contains(menu)) {
            return false;
        }
        return true;
    }
}
