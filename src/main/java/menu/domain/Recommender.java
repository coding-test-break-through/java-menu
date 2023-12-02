package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.domain.dto.RecommendDto;
import menu.util.RandomMenuRecommendGenerator;

public class Recommender {

    private final String name;

    private List<String> recommendData;
    private final List<String> hateFoods;

    public Recommender(String name, List<String> hateFoods) {
        this.name = name;
        this.recommendData = new ArrayList<>();
        this.hateFoods = hateFoods;
    }

    public void recommendFood(List<String> recommendMenus) {
        String menuName;
        do {
            menuName = new RandomMenuRecommendGenerator().generateFromList(recommendMenus);
        } while (hateFoods.contains(menuName) || recommendData.contains(menuName));

        recommendData.add(menuName);
    }

    public RecommendDto getTotalRecommend() {
        return new RecommendDto(name, recommendData);
    }

}
