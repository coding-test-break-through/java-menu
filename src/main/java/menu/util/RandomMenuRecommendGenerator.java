package menu.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomMenuRecommendGenerator implements RandomGenerator{

    @Override
    public String generateFromList(List<String> menus) {
        return Randoms.shuffle(menus).get(0);
    }

    @Override
    public int pickRandomNumber() {
        return Randoms.pickNumberInRange(1,5);
    }
}
