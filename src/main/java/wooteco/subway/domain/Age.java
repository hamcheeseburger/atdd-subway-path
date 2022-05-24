package wooteco.subway.domain;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public enum Age {

    INFANTS(age -> age >= 0 && age < 6, fare -> 0),
    CHILDREN(age -> age >= 6 && age < 13, fare -> (int) ((fare - 350) * (1 - 0.5))),
    TEENAGERS(age -> age >= 13 && age < 19, fare -> (int) ((fare - 350) * (1 - 0.2))),
    ADULTS(age -> age >= 19, fare -> fare),
    ;

    private final Predicate<Integer> ageDiscriminator;
    private final UnaryOperator<Integer> fareCalculator;

    Age(final Predicate<Integer> ageDiscriminator, final UnaryOperator<Integer> fareCalculator) {
        this.ageDiscriminator = ageDiscriminator;
        this.fareCalculator = fareCalculator;
    }

    public static Age findAge(final int age) {
        return Arrays.stream(values())
                .filter(ageGroup -> ageGroup.ageDiscriminator.test(age))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 연령을 찾을 수 없습니다."));
    }

    public int discountFare(final int fare) {
        return this.fareCalculator.apply(fare);
    }
}
