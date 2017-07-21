import java.util.Optional;

public class B {

    private String value;

    public B(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Optional<String> getValueOptional() {
        return Optional.ofNullable(value);
    }
}
