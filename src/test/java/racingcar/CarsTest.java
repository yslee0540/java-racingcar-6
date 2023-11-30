package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.util.NameParser;

public class CarsTest {

    @DisplayName("정상 상황일 때 Cars가 생성된다.")
    @Test
    void create_cars() {
        List<String> carNames = List.of("pobi", "woni", "jun");

        Cars cars = new Cars(carNames);

        assertAll(
                () -> assertThatCode(() -> new Cars(carNames)).doesNotThrowAnyException(),
                () -> assertThat(cars).isNotNull()
        );
    }

    @DisplayName("중복되는 자동차 이름이 있을 때 예외가 발생한다.")
    @Test
    void throw_exception_when_car_names_duplicate() {
        List<String> duplicatedCarNames = List.of("pobi", "pobi", "jun");

        assertThatThrownBy(() -> new Cars(duplicatedCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("서로 다른 자동차 이름만 입력 가능합니다.");
    }

    @DisplayName("자동차가 한 대일 때 예외가 발생한다.")
    @Test
    void throw_exception_when_invalid_car_size() {
        String singleCarNames = "pobi";

        assertThatThrownBy(() -> new Cars(NameParser.stringToList(singleCarNames)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 5자 이상일 때 예외가 발생한다.")
    @Test
    void throw_exception_when_invalid_car_name() {
        List<String> carNameOverFive = List.of("pobi123", "pobi", "jun");

        assertThatThrownBy(() -> new Cars(carNameOverFive))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
