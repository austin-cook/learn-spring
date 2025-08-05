package pro.austincook.learn_spring.elearningplatform.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.austincook.learn_spring.elearningplatform.model.entity.VideoResourceEntity;

public interface VideoRepository extends JpaRepository<VideoResourceEntity, Integer> {
}
