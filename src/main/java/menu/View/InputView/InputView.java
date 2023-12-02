package menu.View.InputView;

import static menu.Message.PromptMsg.InputPromptMsg.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import menu.View.InputView.InputValidator.CoachNameValidator;
import menu.View.InputView.InputValidator.UnavailableFoodValidator;
import menu.View.InputView.InputValidator.Validator;

public class InputView {

    CoachNameValidator coachNameValidator = new CoachNameValidator();
    UnavailableFoodValidator unavailableFoodValidator = new UnavailableFoodValidator();

    public InputView(){
        System.out.println(PROGRAM_START_NOTICE.getMessage());
    }

    public List<String> coachNamesInput(){
        String coachNameInput = getValidInputWithRetry(
                ASK_INPUT_COACH_NAMES.getMessage(),
                coachNameValidator);

        return Arrays.asList(coachNameInput.split(","));
    }

    public List<String> unavailableMenuInput(String coachName){
        String unavailableFoodInput = getValidInputWithRetry(
                String.format(ASK_INPUT_UNAVAILABLE_MENU_FOR_COACH.getMessage(), coachName),
                unavailableFoodValidator);
        return Arrays.asList(unavailableFoodInput.split(","));
    }


    private String getValidInputWithRetry(String message, Validator validator) {
        while (true) {
            try {
                System.out.println(message);
                String userInput = Console.readLine();
                validator.validate(userInput);
                return userInput;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
