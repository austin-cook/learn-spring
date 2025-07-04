package pro.austincook.learn_spring.studentrestapi.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "schools")
public class SchoolEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @OneToMany(
            mappedBy = "schoolEntity"
    )
    @JsonManagedReference // <- prevents infinite loop references between school and student. School to include full JSON of students
    private List<StudentEntity> studentEntities;

    // Empty constructor needed for JPA
    public SchoolEntity() {
    }

    public SchoolEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<StudentEntity> getStudentEntities() {
        return studentEntities;
    }

    public void setStudentsEntities(List<StudentEntity> studentEntities) {
        this.studentEntities = studentEntities;
    }
}
