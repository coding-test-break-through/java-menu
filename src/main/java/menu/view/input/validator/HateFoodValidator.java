package menu.view.input.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.util.constant.MenuConstant;
import menu.view.input.error.InputError;
import menu.view.input.error.InputIllegalArgumentException;

public class HateFoodValidator {

    public List<String> validate(String inputValue) {
        List<String> hateFoods = divideToList(inputValue);
        validateNotBlankContainList(hateFoods);
        validateOverMaxFoodCount(hateFoods);
        return hateFoods;
    }

    private void validateNotBlankContainList(List<String> inputValue) {
        if (hasBlank(inputValue)) {
            throw new InputIllegalArgumentException(InputError.NOT_POSSIBLE_INPUT);
        }
    }


    private boolean hasBlank(List<String> inputValue) {
        return inputValue.stream()
                .anyMatch(String::isBlank);
    }

    private List<String> divideToList(String inputValue) {
        if (inputValue.isBlank()) {
            return new ArrayList<>();
        }

        return Arrays.stream(inputValue.split(MenuConstant.SPLITER))
                .map(String::trim)
                .toList();
    }

    private void validateOverMaxFoodCount(List<String> hateFoods) {
        if (hateFoods.size() > 2) {
            throw new InputIllegalArgumentException(InputError.NOT_POSSIBLE_INPUT);
        }
    }
}
