package pro.austincook.learn_spring.elearningplatform.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "lectures")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class LectureEntity extends BaseEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(
            name = "section_id"
    )
    @JsonBackReference
    private SectionEntity section;
    @OneToOne
    @JoinColumn(
            name = "resource_id"
    )
    private ResourceEntity resource;
}
