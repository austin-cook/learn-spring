package pro.austincook.learn_spring.studentrestapi.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.austincook.learn_spring.studentrestapi.model.entity.StudentEntity;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
    /*
     Custom query - the name defines how Spring JPA implements it
     "findAllBy"   the base method
     "Firstname"   the field to search
     "Containing"  to have it in it
     */
    List<StudentEntity> findAllByFirstnameContaining(String s);
}
