import java.util.Optional;

public class BWithOptionalField {

    private Optional<String> valueOptional = Optional.empty();

    public BWithOptionalField() {
    }

    public BWithOptionalField(String value) {
        this.valueOptional = Optional.of(value);
    }

    public Optional<String> getValueOptional() {
        return valueOptional;
    }

    public void setValueOptional(Optional<String> valueOptional) {
        this.valueOptional = valueOptional;
    }
}
