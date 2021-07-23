import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.junit.jupiter.api.extension.ReflectiveInvocationContext;

import java.lang.reflect.Method;

public class BenchmarkExtension implements InvocationInterceptor {

    @Override
    public void interceptTestMethod(Invocation<Void> invocation,
                                    ReflectiveInvocationContext<Method> invocationContext,
                                    ExtensionContext extensionContext) throws Throwable {
        long time0 = System.nanoTime();
        invocation.proceed();
        long time1 = System.nanoTime();
        long elapsedTime = time1 - time0;
        System.out.printf("%s Ops/µs: %s%n", invocationContext.getExecutable(), (double) OptionalBenchmark.ITERATION_COUNT / elapsedTime);
    }
}
