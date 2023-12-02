package menu.View.InputView.InputValidator;

import static menu.Constants.DomainConstants.*;
import static menu.Message.Exceptions.CoachNameErrMsg.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CoachNameValidator implements Validator{

    private final String STRING_REGULAR_EXPRESSION = "^[a-zA-Z가-힣]+(,[a-zA-Z가-힣]+)*$";
    private final String WHITE_SPACE = " ";

    public void validate(String userInput){
        isBlankInput(userInput);
        isEmptyInput(userInput);
        containsNoWhiteSpace(userInput);
        isRightFormat(userInput);
        List<String> names = Arrays.asList(userInput.split(","));
        areNamesMoreThanMin(names);
        areNamesLessThanMax(names);
        isNameLengthInValidRange(names);
        isNotDuplicated(names);
    }

    public void isBlankInput(String userInput) throws IllegalArgumentException {
        if (!userInput.isEmpty() && userInput.isBlank()) {
            throw new IllegalArgumentException(ASK_NO_EMPTY_INPUT.getMessage());
        }
    }

    public void isEmptyInput(String userInput) throws IllegalArgumentException {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException(ASK_NO_EMPTY_INPUT.getMessage());
        }
    }

    public void containsNoWhiteSpace(String userInput) throws IllegalArgumentException {
        if (userInput.contains(WHITE_SPACE)) {
            throw new IllegalArgumentException(ASK_NO_WHITE_SPACE.getMessage());
        }
    }

    public void isRightFormat(String userInput) throws IllegalArgumentException{
        if(!userInput.matches(STRING_REGULAR_EXPRESSION)){
            throw new IllegalArgumentException(ASK_VALID_FORMAT.getMessage());
        }
    }

    // 리스트 안의 원소의 갯수가 맞는지
    public void areNamesMoreThanMin(List<String> userInputGroup) throws IllegalArgumentException {
        if (userInputGroup.size() < COACH_MIN_PEOPLE) {
            throw new IllegalArgumentException(ASK_MORE_THAN_TWO.getMessage());
        }
    }

    public void areNamesLessThanMax(List<String> userInputGroup) throws IllegalArgumentException {
        if (userInputGroup.size() > COACH_MAX_PEOPLE) {
            throw new IllegalArgumentException(ASK_BELOW_FIVE.getMessage());
        }
    }


    // 리스트 내 문자열 원소의 길이가 유효 범위인지
    public void isNameLengthInValidRange(List<String> userInputGroup) throws IllegalArgumentException {
        for (String userInput : userInputGroup) {
            if (userInput.length() < COACH_NAME_LENGTH_MIN || userInput.length() > COACH_NAME_LENGTH_MAX) {
                throw new IllegalArgumentException(ASK_NAME_BETWEEN_ONE_AND_TWENTY.getMessage());
            }
        }
    }


    // 입력된 리스트 안에 중복 원소가 없는지
    public void isNotDuplicated(List<String> userInputGroup) throws IllegalArgumentException {
        Set<String> userInputSet = new HashSet<String>(userInputGroup);
        if (userInputSet.size() != userInputGroup.size()) {
            throw new IllegalArgumentException(ASK_NO_DUPLICATION.getMessage());
        }
    }

}
