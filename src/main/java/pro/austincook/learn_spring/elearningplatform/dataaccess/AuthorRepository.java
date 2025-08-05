package pro.austincook.learn_spring.elearningplatform.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pro.austincook.learn_spring.elearningplatform.model.entity.AuthorEntity;
import java.util.List;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {
    List<AuthorEntity> findAllByFirstName(String firstName);
    List<AuthorEntity> findAllByFirstNameIgnoreCase(String firstName);
    List<AuthorEntity> findAllByFirstNameContainingIgnoreCase(String substr);
    List<AuthorEntity> findAllByFirstNameStartsWithIgnoreCase(String substr);
    List<AuthorEntity> findAllByFirstNameEndsWithIgnoreCase(String substr);
    List<AuthorEntity> findAllByFirstNameInIgnoreCase(List<String> names); // where first name is one of names

    // Custom query - set age of author with id to age
    @Modifying // specifies it's an update query rather than modify
    @Transactional // specifies that the change should occur with a transaction
    @Query("update AuthorEntity a set a.age = :age where a.id = :id")
    int updateAuthorAge(int id, int age);

    // Custom query - set age of every author to specified age
    @Modifying
    @Transactional
    @Query("update AuthorEntity a set a.age = :age")
    int updateAllAuthorAge(int age);

    @Transactional
    List<AuthorEntity> findByAgeNamedQuery(@Param("age") int age);
}
