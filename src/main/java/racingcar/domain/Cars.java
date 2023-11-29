package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String WRONG_LENGTH_ERROR_MESSAGE = "1~5자리만 입력 가능합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "서로 다른 자동차 이름만 입력 가능합니다.";
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        validate(carNames);
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getRoundResult() {
        for (Car car : cars) {
            car.moveForward();
        }
        return cars;
    }

    private void validate(List<String> cars) {
        validateDuplicateNames(cars);
        for (String car : cars) {
            validateLength(car);
        }
    }

    private void validateDuplicateNames(List<String> cars) {
        if (cars.size() != cars.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    private void validateLength(String car) {
        if (car.length() < MIN_LENGTH || car.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(WRONG_LENGTH_ERROR_MESSAGE);
        }
    }

    public List<String> getCarNamesByMaxPosition() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }
}
