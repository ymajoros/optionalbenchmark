import org.junit.Test;

public class OptionalBenchmark {

    public static final int ITERATION_COUNT = 500000000;

    @Test
    public void nullChecksTest() {
        B b = new B("test");
        A a = new A(b);
        int n = 0;
        long time0 = System.nanoTime();
        for (int i = 0; i < ITERATION_COUNT; i++) {
            if (a != null) {
                if (a.getB() != null) {
                    if (a.getB().getValue() != null) {
                        n += a.getB().getValue().length();
                    }
                }
            }

        }
        long time1 = System.nanoTime();
        System.out.println(n);
        long elapsedTime = time1 - time0;
        System.out.println("Ops/µs: " + (double) ITERATION_COUNT / elapsedTime);
    }

    @Test
    public void optionalGettersTest() {
        B b = new B("test");
        A a = new A(b);
        int n = 0;
        long time0 = System.nanoTime();
        for (int i = 0; i < ITERATION_COUNT; i++) {
            i += a.getBOptional()
                    .flatMap(B::getValueOptional)
                    .map(String::length)
                    .orElse(0);
        }
        long time1 = System.nanoTime();
        System.out.println(n);
        long elapsedTime = time1 - time0;
        System.out.println("Ops/µs: " + (double) ITERATION_COUNT / elapsedTime);
    }

    @Test
    public void optionalFieldsTest() {
        BWithOptionalField bWithOptionalField = new BWithOptionalField("test");
        AWithOptionalField aWithOptionalField = new AWithOptionalField(bWithOptionalField);
        int n = 0;
        long time0 = System.nanoTime();
        for (int i = 0; i < ITERATION_COUNT; i++) {
            i += aWithOptionalField.getbWithOptionalFieldOptional()
                    .flatMap(BWithOptionalField::getValueOptional)
                    .map(String::length)
                    .orElse(0);
        }
        long time1 = System.nanoTime();
        System.out.println(n);
        long elapsedTime = time1 - time0;
        System.out.println("Ops/µs: " + (double) ITERATION_COUNT / elapsedTime);
    }

}
