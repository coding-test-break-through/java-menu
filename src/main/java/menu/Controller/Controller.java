package menu.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import menu.Constants.Menu;
import menu.Model.Coaches;
import menu.Model.LunchRecommender;
import menu.View.InputView.InputView;
import menu.View.OutputView.OutputView;

public class Controller {

    List<List<String>> unavailableFoodsGroup;
    List<String> unavailableFoodInput;

    public void play(){
        InputView inputView = new InputView();
        List<String> coachNames = inputView.coachNamesInput();

        unavailableFoodsGroup = new ArrayList<>();
        for (String coachName : coachNames){
            receiveUnavailableFoods(inputView, coachName);
            unavailableFoodsGroup.add(unavailableFoodInput);
        }
        Coaches coaches = new Coaches(coachNames, unavailableFoodsGroup);
        coaches.selectMenuForWeek();
        OutputView outputView = new OutputView();
        outputView.printRecommendedCategory(coaches);
        outputView.printRecommendResult(coaches);
        outputView.printRecommendEnd();
    }

    private void receiveUnavailableFoods(InputView inputView, String coachName) {
        boolean invalidFood;
        do {
            invalidFood = isInputValid(inputView, coachName);
        } while(!invalidFood);
    }

    private boolean isInputValid(InputView inputView, String coachName){
        try{
            unavailableFoodInput = inputView.unavailableMenuInput(coachName);
            Menu.isExistsInMenu(unavailableFoodInput);
            return true;
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
