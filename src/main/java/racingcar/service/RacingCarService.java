package racingcar.service;

import racingcar.domain.Cars;
import racingcar.util.NameParser;
import racingcar.util.NumberValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarService {
    private Cars cars;

    public void initCarNames() {
        String name = InputView.readCarNames();
        cars = new Cars(NameParser.stringToList(name));
    }

    private int initAttemptCount() {
        String count = InputView.readAttemptCount();
        return NumberValidator.stringToInt(count);
    }

    public void playGame() {
        int attemptCount = initAttemptCount();
        OutputView.printGameResultMessage();
        for (int i = 0; i < attemptCount; i++) {
            OutputView.printGameResult(cars.getRoundResult());
        }
    }

    public String getWinners() {
        return String.join(", ", cars.findWinners());
    }
}
