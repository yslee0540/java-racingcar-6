package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    private static final String GAME_RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public static void printGameResultMessage() {
        System.out.println(GAME_RESULT_MESSAGE);
    }

    public static void printGameResult(List<Car> cars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            stringBuilder.append(car.getName() + " : " + getPosition(car) + "\n");
        }
        System.out.println(stringBuilder);
    }

    private static String getPosition(Car car) {
        return "-".repeat(Math.max(0, car.getPosition()));
    }

    public static void printWinners(String winners) {
        System.out.println(WINNER_MESSAGE + winners);
    }
}
