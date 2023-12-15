package menu;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    public enum Category {
        JAPANESE, KOREAN, CHINESE, ASIAN, WESTERN
    }

    public enum Food {
        GYUDON("규동", Category.JAPANESE), UDON("우동", Category.JAPANESE), MISO_SOUP("미소시루", Category.JAPANESE),
        SUSHI("스시", Category.JAPANESE), KATSUDON("가츠동", Category.JAPANESE), ONIGIRI("오니기리", Category.JAPANESE),
        HAYASHI_RICE("하이라이스", Category.JAPANESE), RAMEN("라멘", Category.JAPANESE), OKONOMIYAKI("오코노미야끼", Category.JAPANESE),
        GIMBAP("김밥", Category.KOREAN), KIMCHI_STEW("김치찌개", Category.KOREAN), SSAM_BAP("쌈밥", Category.KOREAN),
        DOENJANG_STEW("된장찌개", Category.KOREAN), BIBIMBAP("비빔밥", Category.KOREAN), KALGUKSU("칼국수", Category.KOREAN),
        BULGOGI("불고기", Category.KOREAN), TTEOKBOKKI("떡볶이", Category.KOREAN), JAEYUK_BOKKEUM("제육볶음", Category.KOREAN),
        KANPOONGI("깐풍기", Category.CHINESE), STIR_FRIED_NOODLES("볶음면", Category.CHINESE), DONGPO_PORK("동파육", Category.CHINESE),
        JAJANGMYEON("짜장면", Category.CHINESE), JJAMPPONG("짬뽕", Category.CHINESE), MAPO_TOFU("마파두부", Category.CHINESE),
        SWEET_AND_SOUR_PORK("탕수육", Category.CHINESE), TOMATO_EGG_STIR_FRY("토마토 달걀볶음", Category.CHINESE), HOT_PEPPER_JAPCHAE("고추잡채", Category.CHINESE),
        PAD_THAI("팟타이", Category.ASIAN), KHAO_PAD("카오 팟", Category.ASIAN), NASI_GORENG("나시고렝", Category.ASIAN),
        PINEAPPLE_FRIED_RICE("파인애플 볶음밥", Category.ASIAN), PHO("쌀국수", Category.ASIAN), TOM_YUM_KUNG("똠얌꿍", Category.ASIAN),
        BANH_MI("반미", Category.ASIAN), SPRING_ROLLS("월남쌈", Category.ASIAN), BUN_CHA("분짜", Category.ASIAN),
        LASAGNA("라자냐", Category.WESTERN), GRATIN("그라탱", Category.WESTERN), GNOCCHI("뇨끼", Category.WESTERN),
        QUICHE("끼슈", Category.WESTERN), FRENCH_TOAST("프렌치 토스트", Category.WESTERN), BAGUETTE("바게트", Category.WESTERN),
        SPAGHETTI("스파게티", Category.WESTERN), PIZZA("피자", Category.WESTERN), PANINI("파니니", Category.WESTERN);

        private final String koreanName;
        private final Category category;
        private static final Map<String, Food> BY_KOREAN_NAME = new HashMap<>();

        static {
            for (Food food : values()) {
                BY_KOREAN_NAME.put(food.koreanName, food);
            }
        }

        Food(String koreanName, Category category) {
            this.koreanName = koreanName;
            this.category = category;
        }

        public static Food valueOfKoreanName(String koreanName) {
            return BY_KOREAN_NAME.get(koreanName);
        }

        public Category getCuisine() {
            return category;
        }
    }
}