import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Optional;

@ExtendWith(BenchmarkExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OptionalBenchmark {

    public static final int ITERATION_COUNT = 1000000000;

    @Test
    @Order(1)
    public void optionalFieldsTest() {
        BWithOptionalField bWithOptionalField = new BWithOptionalField("test");
        AWithOptionalField aWithOptionalField = new AWithOptionalField(bWithOptionalField);
        int n = 0;
        for (int i = 0; i < ITERATION_COUNT; i++) {
            n += aWithOptionalField.getbWithOptionalFieldOptional()
                    .flatMap(BWithOptionalField::getValueOptional)
                    .map(String::length)
                    .orElse(0);
        }
    }

    @Test
    @Order(2)
    public void optionalGettersTest() {
        B b = new B("test");
        A a = new A(b);
        int n = 0;
        for (int i = 0; i < ITERATION_COUNT; i++) {
            n += a.getBOptional()
                    .flatMap(B::getValueOptional)
                    .map(String::length)
                    .orElse(0);
        }
    }

    @Test
    @Order(3)
    public void nullChecksTest() {
        B b = new B("test");
        A a = new A(b);
        int n = 0;
        for (int i = 0; i < ITERATION_COUNT; i++) {
            if (a != null) {
                if (a.getB() != null) {
                    if (a.getB().getValue() != null) {
                        n += a.getB().getValue().length();
                    }
                }
            }
        }
    }

    @Test
    @Order(4)
    public void optionalInstances() {
        for (int i = 0; i < ITERATION_COUNT; i++) {
            Optional<Integer> x = Optional.of(i);
        }
    }

    @Test
    @Order(5)
    public void integerInstances() {
        for (int i = 0; i < ITERATION_COUNT; i++) {
            Integer j = new Integer(i);
        }
    }

    @Test
    @Order(6)
    public void intIntern() {
        for (int i = 0; i < ITERATION_COUNT; i++) {
            Integer j = i;
        }
    }

}


