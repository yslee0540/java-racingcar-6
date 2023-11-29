package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class NameParser {
    public static List<String> stringToList(String input) {
        validateDelimiter(input);
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();
    }
    
    private static void validateDelimiter(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("쉼표가 포함되어야 합니다.");
        }
    }
}
