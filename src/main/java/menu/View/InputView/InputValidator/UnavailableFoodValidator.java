package menu.View.InputView.InputValidator;

import static menu.Constants.DomainConstants.NON_AVAIL_FOOD_MAX;
import static menu.Message.Exceptions.UnavailableFoodErrMsg.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UnavailableFoodValidator implements Validator {

    private final String STRING_REGULAR_EXPRESSION = "^[가-힣, ]*$";
    public void validate(String userInput){
        isRightFormat(userInput);
        List<String> unavailableFoods = Arrays.asList(userInput.split(","));
        if (unavailableFoods.contains("")){
            return;
        }
        areLessThanMax(unavailableFoods);
        isNotDuplicated(unavailableFoods);
    }

    public void isRightFormat(String userInput) throws IllegalArgumentException{
        if(!userInput.matches(STRING_REGULAR_EXPRESSION)){
            throw new IllegalArgumentException(ASK_VALID_FORMAT.getMessage());
        }
    }

    public void areLessThanMax(List<String> userInputGroup) throws IllegalArgumentException {
        if (userInputGroup.size() > NON_AVAIL_FOOD_MAX) {
            throw new IllegalArgumentException(ASK_BELOW_TWO.getMessage());
        }
    }

    public void isNotDuplicated(List<String> userInputGroup) throws IllegalArgumentException {
        Set<String> userInputSet = new HashSet<String>(userInputGroup);
        if (userInputSet.size() != userInputGroup.size()) {
            throw new IllegalArgumentException(ASK_NO_DUPLICATION.getMessage());
        }
    }
}
