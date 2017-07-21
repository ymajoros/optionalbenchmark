import java.util.Optional;

public class AWithOptionalField {

    private Optional<BWithOptionalField> bWithOptionalFieldOptional;

    public AWithOptionalField() {
    }

    public AWithOptionalField(BWithOptionalField bWithOptionalField) {
        this.bWithOptionalFieldOptional = Optional.of(bWithOptionalField);
    }

    public Optional<BWithOptionalField> getbWithOptionalFieldOptional() {
        return bWithOptionalFieldOptional;
    }

    public void setbWithOptionalFieldOptional(Optional<BWithOptionalField> bWithOptionalFieldOptional) {
        this.bWithOptionalFieldOptional = bWithOptionalFieldOptional;
    }
}
