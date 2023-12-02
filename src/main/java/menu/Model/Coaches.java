package menu.Model;

import java.util.ArrayList;
import java.util.List;
import menu.Constants.Menu;

public class Coaches {

    List<Coach> coaches;
    List<String> categoryMemo;

    LunchRecommender lunchRecommender = new LunchRecommender();

    public Coaches(List<String> coachNames, List<List<String>> unavailableFoods) {
        categoryMemo = new ArrayList<>();
        coaches = new ArrayList<>();
        for (int i = 0; i < coachNames.size(); i++) {
            coaches.add(new Coach(coachNames.get(i), unavailableFoods.get(i)));
        }
    }

    public void selectMenuForWeek(){
        for (int i=0; i <5; i++){
            Integer categoryNum = lunchRecommender.categorySelector();
            categoryMemo.add(Menu.getCategoryNameByCategoryNum(categoryNum));
            selectLunchMenuForTheDay(categoryNum);
        }
    }

    private void selectLunchMenuForTheDay(Integer categoryNum){
        for (Coach coach : coaches){
            coach.addRecommendMenu(lunchRecommender.recommendLunchMenu(coach, categoryNum));
        }
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public List<String> getCategoryMemo() {
        return categoryMemo;
    }
}
