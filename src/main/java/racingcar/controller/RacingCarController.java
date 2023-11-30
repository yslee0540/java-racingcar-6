package racingcar.controller;

import racingcar.service.RacingCarService;
import racingcar.view.OutputView;

public class RacingCarController {
    private final RacingCarService racingCarService;

    public RacingCarController() {
        this.racingCarService = new RacingCarService();
    }

    public void startGame() {
        racingCarService.initCarNames();
        racingCarService.playGame();
        findWinners();
    }

    private void findWinners() {
        OutputView.printWinners(String.join(", ", racingCarService.getWinners()));
    }
}
