package menu.Model;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private List<String> unavailableFoods;
    private List<String> recommendedFoods;

    public Coach(String name, List<String> unavailableFoods){
        this.name = name;
        this.unavailableFoods = unavailableFoods;
        this.recommendedFoods = new ArrayList<>();
    };

    public void addRecommendMenu(String menu){
        recommendedFoods.add(menu);
    }

    public String getName() {
        return name;
    }

    public List<String> getRecommendedFoods() {
        return recommendedFoods;
    }

    public List<String> getUnavailableFoods() {
        return unavailableFoods;
    }
}
