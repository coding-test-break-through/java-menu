package menu;

import java.util.Objects;

public class Validator {
    void checkNames(String input) {
        String[] parsedInput = input.split(",");
        checkNumberOfNames(parsedInput);
        for (String string : parsedInput) {
            checkLengthOfName(string);
        }
    }

    void checkNumberOfNames(String[] input) {
        if (input.length > 5 || input.length < 2) {
            throw new IllegalArgumentException("[ERROR] 코치는 2명 이상 5명 이하여야 합니다.");
        }
    }

    void checkLengthOfName(String input) {
        if (input.length() > 4 || input.length() < 2) {
            throw new IllegalArgumentException("[ERROR] 코치의 이름은 2글자 이상 4글자 이하여야 합니다.");
        }
    }

    void checkMenus(String input) {
        if (Objects.equals(input, "")) {
            return;
        }
        String[] parsedInput = input.split(",");
        checkNumberOfMenus(parsedInput);
        for (String string : parsedInput) {
            checkExistOfMenu(string);
        }
    }

    void checkNumberOfMenus(String[] input) {
        if (input.length > 2) {
            throw new IllegalArgumentException("[ERROR] 못 먹는 메뉴의 개수는 2개 이하여야 합니다.");
        }
    }

    void checkExistOfMenu(String input) {
        if (Menu.Food.valueOfKoreanName(input) == null) {
            throw new IllegalArgumentException("[ERROR] 추천 메뉴 목록에 없는 메뉴입니다.");
        }
    }
}
