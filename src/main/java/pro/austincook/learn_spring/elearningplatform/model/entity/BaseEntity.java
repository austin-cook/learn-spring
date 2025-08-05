package pro.austincook.learn_spring.elearningplatform.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@MappedSuperclass // Needed if any class is composed of it
@SuperBuilder // for parent/base class
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {
    @Id
    @GeneratedValue
    private Integer id;
//    @Column(
//            updatable = false,
//            nullable = false
//    )
    private LocalDateTime createdAt;
//    @Column(
//            insertable = false
//    )
    private LocalDateTime lastModified;
    private String createdBy;
    private String lastModifiedBy;
}
