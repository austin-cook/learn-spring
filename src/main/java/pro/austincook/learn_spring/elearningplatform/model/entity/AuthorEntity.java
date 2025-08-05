package pro.austincook.learn_spring.elearningplatform.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "authors")
@Data // from lombok - is @Getter, @Setter, @RequiredArgsConstructor, @ToString, and @EqualsAndHashCode
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor // from lombok - generates constructor with no args
@AllArgsConstructor
@SuperBuilder
@NamedQuery(
        name = "AuthorEntity.findByAgeNamedQuery",
        query = "select a from AuthorEntity a where a.age = :age"
)
public class AuthorEntity extends BaseEntity {
    @Column(
            name = "f_name",
            length = 35
    )
    private String firstName;
    private String lastName;
    @Column(
            unique = true,
            nullable = false
    )
    private String email;
    private int age;
    @ManyToMany(mappedBy = "authors") // mapped by since Authors owned by Course
    private List<CourseEntity> courses;

    @Override
    public String toString() {
        return "(Author: " +  firstName + ", " + lastName + ", " + email + ", age: " + age + ")";
    }
}
