package pro.austincook.learn_spring.studentrestapi.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "students") // NOTE - To give table different name than the class
public class StudentEntity {
    @Id // NOTE - Must use @Id on a field to mark as primary key
    @GeneratedValue // Set to auto-generate primary key value
    private Integer id;
    @Column(
            name = "c_fname",
            length = 20
    )
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String email;
    private int age;
    @OneToOne(
            mappedBy = "studentEntity", // field name in StudentProfile.java
            cascade = CascadeType.ALL
    )
    private StudentProfileEntity studentProfileEntity;
    @ManyToOne
    @JoinColumn(
            name = "school_id"
    )
    @JsonBackReference // <- prevents infinite loop references between school and student. Student to not include full JSON of its school. Also makes school not show up as a table column.
    private SchoolEntity schoolEntity;

    // NOTE - Spring JPA requires a constructor with no args
    public StudentEntity() {
    }

    public StudentEntity(String firstname, String lastname, String email, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public StudentProfileEntity getStudentProfile() {
        return studentProfileEntity;
    }

    public void setStudentProfile(StudentProfileEntity studentProfileEntity) {
        this.studentProfileEntity = studentProfileEntity;
    }

    public SchoolEntity getSchoolEntity() {
        return schoolEntity;
    }

    public void setSchoolEntity(SchoolEntity schoolEntity) {
        this.schoolEntity = schoolEntity;
    }
}
