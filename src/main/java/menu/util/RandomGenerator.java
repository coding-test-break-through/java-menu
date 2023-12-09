package menu.util;

import java.util.List;

public interface RandomGenerator {

    String generateFromList(List<String> randoms);

    int pickRandomNumber();
}
