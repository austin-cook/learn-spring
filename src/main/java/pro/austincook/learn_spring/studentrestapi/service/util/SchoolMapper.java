package pro.austincook.learn_spring.studentrestapi.service.util;

import org.springframework.stereotype.Service;
import pro.austincook.learn_spring.studentrestapi.model.dto.SchoolRequestResponseDto;
import pro.austincook.learn_spring.studentrestapi.model.entity.SchoolEntity;

@Service
public class SchoolMapper {
    public SchoolEntity toSchoolEntity(SchoolRequestResponseDto dto) {
        return new SchoolEntity(dto.name());
    }

    public SchoolRequestResponseDto toSchoolRequestresponseDto(SchoolEntity schoolEntity) {
        return new SchoolRequestResponseDto(schoolEntity.getName());
    }
}
