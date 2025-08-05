package pro.austincook.learn_spring.elearningplatform.model.entity.embedded;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable // needed to make the field from this class embeddable in an entity
public class Address {
    private String streetName;
    private String houseNumber;
    private String zipCode;
}
