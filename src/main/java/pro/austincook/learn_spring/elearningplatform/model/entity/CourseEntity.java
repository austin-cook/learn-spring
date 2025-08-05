package pro.austincook.learn_spring.elearningplatform.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "courses")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CourseEntity extends BaseEntity {
    private String title;
    private String description;
    @ManyToMany
    @JoinTable( // course owns authors
            name = "authors_courses",
            joinColumns = {
                    @JoinColumn(name = "course_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "author_id")
            }
    )
    private List<AuthorEntity> authors;
    @OneToMany(
            mappedBy = "course"
    )
    @JsonManagedReference
    private List<SectionEntity> sections;
}
