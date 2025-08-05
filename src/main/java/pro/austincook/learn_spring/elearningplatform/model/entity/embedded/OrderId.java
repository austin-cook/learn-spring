package pro.austincook.learn_spring.elearningplatform.model.entity.embedded;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable // Tells hibernate that it's an embedded entity
public class OrderId  implements Serializable { // EmbeddedId must implement Serializable
    private String username;
    private LocalDateTime orderDate;
}
