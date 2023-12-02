package menu.Model;

import static menu.Constants.DomainConstants.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.Constants.Menu;

public class LunchRecommender {

    private Map<Integer, Integer> categoryCount;

    public LunchRecommender(){
        categoryCount = new HashMap<>();
        for (int i = CATEGORY_NUMBER_START; i <= CATEGORY_NUMBER_END; i++) {
            categoryCount.put(i, 0);
        }
    }

    public Integer categorySelector() {
        Integer categoryCandidate;
        do {
            categoryCandidate = Randoms.pickNumberInRange(CATEGORY_NUMBER_START, CATEGORY_NUMBER_END);
        } while (categoryCount.get(categoryCandidate) >= CATEGORY_MAX_RECOMMEND_AMOUNT);

        categoryCount.merge(categoryCandidate, 1, Integer::sum);
        return categoryCandidate;
    }

    private String menuSelector(Coach coach, Integer categoryNum){
        List<String> RandomizedFoodList = Randoms.shuffle(menu.Constants.Menu.getFoodListByCategoryNum(categoryNum));
        for (String recCandidate : RandomizedFoodList) {
            if (!coach.getUnavailableFoods().contains(recCandidate) && !coach.getRecommendedFoods().contains(recCandidate)) {
                return recCandidate;
            }
        }
        return null;
    }

    public String recommendLunchMenu(Coach coach, Integer categoryNum) {
        String selectedMenu;
        do {
            selectedMenu = menuSelector(coach, categoryNum);
        } while (selectedMenu == null);
        return selectedMenu;
    }
}
