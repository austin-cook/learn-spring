package pro.austincook.learn_spring.elearningplatform.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "sections")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class SectionEntity extends BaseEntity {
    private String name;
    private int sectionOrder;
    @ManyToOne
    @JoinColumn(
            name = "course_id"
    )
    @JsonBackReference
    private CourseEntity course;
    @OneToMany(mappedBy = "section")
    @JsonManagedReference
    private List<LectureEntity> lectures;
}
