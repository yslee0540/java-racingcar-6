package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

@DisplayName("Car 단위 테스트")
class CarTest {

    @DisplayName("정상 상황일 때 자동차가 생성된다.")
    @Test
    void create_car() {
        String carName = "pobi";

        Car car = new Car(carName);

        assertAll(
                () -> assertThatCode(() -> new Car(carName)).doesNotThrowAnyException(),
                () -> assertThat(car).isNotNull()
        );
    }

    @DisplayName("자동차 전진 테스트")
    @Test
    void testDrive() {
        Car car = new Car("Test");

        car.moveForward();
        car.moveForward();
        car.moveForward();

        int currentPosition = car.getPosition();
        String showCurrentPosition = car.showPosition();

        assertThat(currentPosition).isEqualTo(showCurrentPosition.length());
    }
}