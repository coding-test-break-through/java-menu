package menu.Constants;

import static menu.Message.Exceptions.UnavailableFoodErrMsg.ASK_FOOD_WHICH_IS_IN_MENU;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum Menu {
    JAPANESE_FOOD("일식", 1, Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREAN_FOOD("한식", 2, Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINESE_FOOD("중식", 3, Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN_FOOD("아시안", 4, Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WESTERN_FOOD("양식", 5, Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    private String category;
    private Integer categoryNum;
    private List<String> foodList;

    Menu(String category, Integer categoryNum, List<String> foodList) {
        this.category = category;
        this.categoryNum = categoryNum;
        this.foodList = foodList;
    }

    public static void isExistsInMenu(List<String> requestedFoods) throws IllegalArgumentException {
        boolean valid =  requestedFoods.stream()
                .allMatch(requestedFood -> Arrays.stream(Menu.values())
                        .anyMatch(menu -> menu.foodList.contains(requestedFood)));
        if (!valid){
            throw new IllegalArgumentException(ASK_FOOD_WHICH_IS_IN_MENU.getMessage());
        }
    }

    public static List<String> getFoodListByCategoryNum(Integer categoryNum) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.categoryNum.equals(categoryNum))
                .findFirst()
                .map(menu -> menu.foodList)
                .orElse(Collections.emptyList());
    }

    public static String getCategoryNameByCategoryNum(Integer categoryNum) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.categoryNum.equals(categoryNum))
                .findFirst()
                .map(menu -> menu.category)
                .orElse(null);
    }
}