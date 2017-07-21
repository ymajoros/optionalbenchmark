import java.util.Optional;

public class A {
    private B b;

    public A(B b) {
        this.b = b;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public Optional<B> getBOptional() {
        return Optional.ofNullable(b);
    }
}
