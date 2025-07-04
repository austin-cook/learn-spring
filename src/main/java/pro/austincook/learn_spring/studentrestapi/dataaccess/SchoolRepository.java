package pro.austincook.learn_spring.studentrestapi.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.austincook.learn_spring.studentrestapi.model.entity.SchoolEntity;

public interface SchoolRepository extends JpaRepository<SchoolEntity, Integer> {
}
