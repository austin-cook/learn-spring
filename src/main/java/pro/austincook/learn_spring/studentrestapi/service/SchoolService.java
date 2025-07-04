package pro.austincook.learn_spring.studentrestapi.service;

import org.springframework.stereotype.Service;
import pro.austincook.learn_spring.studentrestapi.dataaccess.SchoolRepository;
import pro.austincook.learn_spring.studentrestapi.model.dto.SchoolRequestResponseDto;
import pro.austincook.learn_spring.studentrestapi.model.entity.SchoolEntity;
import pro.austincook.learn_spring.studentrestapi.service.util.SchoolMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    private final SchoolRepository repository;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository repository, SchoolMapper schoolMapper) {
        this.repository = repository;
        this.schoolMapper = schoolMapper;
    }

    public SchoolRequestResponseDto createSchool(
            SchoolRequestResponseDto dto
    ) {
        SchoolEntity schoolEntity = schoolMapper.toSchoolEntity(dto);
        return schoolMapper.toSchoolRequestresponseDto(repository.save(schoolEntity));
    }

    public List<SchoolRequestResponseDto> findAllStudents() {
        return repository.findAll()
                .stream()
                .map(schoolMapper::toSchoolRequestresponseDto)
                .collect(Collectors.toList());
    }
}
