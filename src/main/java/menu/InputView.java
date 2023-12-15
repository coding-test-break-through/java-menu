package menu;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static final String REQUEST_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";
    public static final String REQUEST_MENU = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    public static final String SEPARATOR = ",";
    private final Validator validator = new Validator();

    List<String> readNames() {
        while (true) {
            try {
                System.out.println(REQUEST_NAME);
                String names = Console.readLine();
                validator.checkNames(names);
                System.out.println();
                return Arrays.stream(names.split(SEPARATOR))
                        .collect(Collectors.toList());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    List<String> readMenus(String name) {
        while (true) {
            try {
                System.out.println(name + REQUEST_MENU);
                String menus = Console.readLine();
                validator.checkMenus(menus);
                System.out.println();
                return Arrays.stream(menus.split(SEPARATOR))
                        .collect(Collectors.toList());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
