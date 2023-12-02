package menu.view.input.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.util.constant.MenuConstant;
import menu.view.input.error.InputError;
import menu.view.input.error.InputIllegalArgumentException;

public class HateFoodValidator {

    private static final int MAX_HATE_FOOD_COUNT = 2;
    private static final int MIN_HATE_FOOD_COUNT = 1;

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
        if (hateFoods.size() > MAX_HATE_FOOD_COUNT || hateFoods.size() < MIN_HATE_FOOD_COUNT) {
            throw new InputIllegalArgumentException(InputError.NOT_POSSIBLE_INPUT);
        }
    }
}
