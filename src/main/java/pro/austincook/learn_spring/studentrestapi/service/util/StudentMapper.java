package pro.austincook.learn_spring.studentrestapi.service.util;

import org.springframework.stereotype.Service;
import pro.austincook.learn_spring.studentrestapi.model.dto.request.StudentRequestDto;
import pro.austincook.learn_spring.studentrestapi.model.dto.response.StudentResponseDto;
import pro.austincook.learn_spring.studentrestapi.model.entity.SchoolEntity;
import pro.austincook.learn_spring.studentrestapi.model.entity.StudentEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service // Service is a child of @Component
public class StudentMapper {
    public StudentEntity toStudentEntity(StudentRequestDto dto) {
        if (dto == null) {
            throw new NullPointerException("The StudentRequestDto is null");
        }

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setFirstname(dto.firstname());
        studentEntity.setLastname(dto.lastname());
        studentEntity.setEmail(dto.email());

        SchoolEntity schoolEntity = new SchoolEntity();
        schoolEntity.setId(dto.schoolId());
        studentEntity.setSchoolEntity(schoolEntity);

        return studentEntity;
    }

    public StudentResponseDto toStudentResponseDto(StudentEntity studentEntity) {
        return new StudentResponseDto(
                studentEntity.getFirstname(),
                studentEntity.getLastname(),
                studentEntity.getEmail()
        );
    }

    public List<StudentResponseDto > toStudentResponseDtos(List<StudentEntity> studentEntities) {
        return studentEntities.stream()
                .map(this::toStudentResponseDto)
                .collect(Collectors.toList());
    }
}
