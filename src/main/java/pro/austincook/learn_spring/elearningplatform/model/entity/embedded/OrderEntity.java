package pro.austincook.learn_spring.elearningplatform.model.entity.embedded;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    @EmbeddedId
    private OrderId orderId;

    @Embedded // embedded entity
    private Address address;

    private String orderInfo;
    private String anotherField;
}
