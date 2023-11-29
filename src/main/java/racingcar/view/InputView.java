package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static String readCarNames() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        return Console.readLine().trim();
    }

    public static String readAttemptCount() {
        System.out.println(ATTEMPT_COUNT_INPUT_MESSAGE);
        return Console.readLine().trim();
    }
}
