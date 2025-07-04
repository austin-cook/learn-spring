package pro.austincook.learn_spring.studentrestapi.service;

import org.springframework.stereotype.Service;
import pro.austincook.learn_spring.studentrestapi.dataaccess.StudentRepository;
import pro.austincook.learn_spring.studentrestapi.model.dto.request.StudentRequestDto;
import pro.austincook.learn_spring.studentrestapi.model.dto.response.StudentResponseDto;
import pro.austincook.learn_spring.studentrestapi.model.entity.StudentEntity;
import pro.austincook.learn_spring.studentrestapi.service.util.StudentMapper;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.repository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(StudentRequestDto studentRequestDto) {
        StudentEntity studentEntity = studentMapper.toStudentEntity(studentRequestDto);
        StudentEntity savedStudent = repository.save(studentEntity);
        return studentMapper.toStudentResponseDto(savedStudent);
    }

    public List<StudentResponseDto> findAllStudents() {
        return studentMapper.toStudentResponseDtos(
                repository.findAll());
    }

    public StudentResponseDto findStudentById(
            Integer id
    ) {
        return studentMapper.toStudentResponseDto(
                repository.findById(id)
                        .orElse(new StudentEntity()));
    }

    public List<StudentResponseDto> findStudentsByName(
            String name
    ) {
        return studentMapper.toStudentResponseDtos(
                repository.findAllByFirstnameContaining(name));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
