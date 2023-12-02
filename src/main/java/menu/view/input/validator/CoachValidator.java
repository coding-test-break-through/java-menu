package menu.view.input.validator;

import java.util.Arrays;
import java.util.List;
import menu.view.input.error.InputError;
import menu.view.input.error.InputIllegalArgumentException;

public class CoachValidator {

    public List<String> validate(String coache) {
        validateNotBlank(coache);
        List<String> coaches = divideToList(coache);
        validateAllInRangeName(coaches);
        return coaches;
    }

    private void validateNotBlank(String inputValue) {
        if (inputValue.isBlank()) {
            throw new InputIllegalArgumentException(InputError.INPUT_IS_BLANK);
        }
    }

    private List<String> divideToList(String inputValue) {
        return Arrays.stream(inputValue.split(","))
                .map(String::trim)
                .toList();
    }

    private boolean hasOverLengthName(List<String> inputValue) {
        return inputValue.stream()
                .anyMatch(input -> isNotInRangeName(input.length()));
    }

    private void validateAllInRangeName(List<String> inputValue) {
        if (hasOverLengthName(inputValue) || isNotInRangeCoachCount(inputValue.size())) {
            throw new InputIllegalArgumentException(InputError.NOT_POSSIBLE_INPUT);
        }
    }

    private boolean isNotInRangeName(int number) {
        return number < 2 || number > 4;
    }

    private boolean isNotInRangeCoachCount(int number) {
        return number < 2 || number > 5;
    }
}
