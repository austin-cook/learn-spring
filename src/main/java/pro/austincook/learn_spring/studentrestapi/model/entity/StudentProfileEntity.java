package pro.austincook.learn_spring.studentrestapi.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student_profiles")
public class StudentProfileEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String bio;
    @OneToOne
    @JoinColumn(
            name = "student_id"
    )
    private StudentEntity studentEntity;

    // Empty constructor needed for JPA
    public StudentProfileEntity() {
    }

    public StudentProfileEntity(String bio) {
        this.bio = bio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public StudentEntity getStudent() {
        return studentEntity;
    }

    public void setStudent(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }
}
