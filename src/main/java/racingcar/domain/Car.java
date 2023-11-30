package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class Car {
    private static final int MOVING_FORWARD = 4;
    private final String name;
    private int position;
    private final RandomNumberGenerator randomNumberGenerator;

    public Car(String name) {
        this.name = name;
        this.position = 0;
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        if (randomNumberGenerator.generate() >= MOVING_FORWARD) {
            position++;
        }
    }
    public String showPosition() {
        return "-".repeat(Math.max(0, getPosition()));
    }
}
