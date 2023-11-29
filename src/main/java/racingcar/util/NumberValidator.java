package racingcar.util;

public class NumberValidator {
    private final static String NON_NUMERIC_ERROR_MESSAGE = "숫자로만 이루어진 값을 입력해주세요.";
    private static final String WRONG_RANGE_ERROR_MESSAGE = "1 이상의 숫자만 입력 가능합니다.";
    private static final int MIN_NUMBER = 1;

    public static int stringToInt(String input) {
        try {
            int count = Integer.parseInt(input);
            validateRange(count);
            return count;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(NON_NUMERIC_ERROR_MESSAGE);
        }
    }

    private static void validateRange(int input) {
        if (input < MIN_NUMBER) {
            throw new IllegalArgumentException(WRONG_RANGE_ERROR_MESSAGE);
        }
    }
}
