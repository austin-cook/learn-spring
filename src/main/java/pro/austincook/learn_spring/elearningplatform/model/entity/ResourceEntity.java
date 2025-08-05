package pro.austincook.learn_spring.elearningplatform.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "resources")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // needed for inheritance and to specify strategy
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ResourceEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private int size;
    private String url;
    @OneToOne
    @JoinColumn(
            name = "lecture_id"
    )
    private LectureEntity lecture;
}
