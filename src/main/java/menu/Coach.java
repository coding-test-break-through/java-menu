package menu;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    List<String> menus = new ArrayList<>();

    Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    void setMenus(String menu) {
        menus.add(menu);
    }
}
