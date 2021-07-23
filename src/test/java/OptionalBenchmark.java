import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(BenchmarkExtension.class)
public class OptionalBenchmark {

    public static final int ITERATION_COUNT = 1000000000;

    @Test
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

}
