package pro.austincook.learn_spring.studentrestapi.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pro.austincook.learn_spring.studentrestapi.dataaccess.StudentRepository;
import pro.austincook.learn_spring.studentrestapi.model.dto.request.StudentRequestDto;
import pro.austincook.learn_spring.studentrestapi.model.dto.response.StudentResponseDto;
import pro.austincook.learn_spring.studentrestapi.model.entity.StudentEntity;
import pro.austincook.learn_spring.studentrestapi.service.util.StudentMapper;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {
    // service to test
    @InjectMocks
    private StudentService studentService;

    // mocks for creating the service
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldSaveAStudent() {
        // Given
        StudentRequestDto studentRequestDto = new StudentRequestDto("John", "Doe", "john@mail.com", 1);

        // Mock calls
        StudentEntity mockStudentEntity = new StudentEntity("John", "Doe", "john@mail.com", 20);
        StudentEntity mockSavedStudentEntity = new StudentEntity("John", "Doe", "john@mail.com", 20);
        mockSavedStudentEntity.setId(1);
        StudentResponseDto mockStudentResponseDto = new StudentResponseDto("John", "Doe", "john@mail.com");

        when(studentMapper.toStudentEntity(studentRequestDto)).thenReturn(mockStudentEntity);
        when(studentRepository.save(mockStudentEntity)).thenReturn(mockSavedStudentEntity);
        when(studentMapper.toStudentResponseDto(mockSavedStudentEntity)).thenReturn(mockStudentResponseDto);

        // When
        StudentResponseDto studentResponseDto = studentService.saveStudent(studentRequestDto);

        // Then
        assertEquals(studentRequestDto.firstname(), studentResponseDto.firstname());
        assertEquals(studentRequestDto.lastname(), studentResponseDto.lastname());
        assertEquals(studentRequestDto.email(), studentResponseDto.email());

        verify(studentMapper, times(1)).toStudentEntity(studentRequestDto);
        verify(studentRepository, times(1)).save(mockStudentEntity);
        verify(studentMapper, times(1)).toStudentResponseDto(mockSavedStudentEntity);
    }

    @Test
    public void shouldFindAllStudents() {
        // Mock calls
        List<StudentEntity> mockStudentEntities = Arrays.asList(
                new StudentEntity("first1", "last1", "name1@mail.com", 20),
                new StudentEntity("first2", "last2", "name2@mail.com", 20));
        List<StudentResponseDto> mockStudentResponseDtos = Arrays.asList(
                new StudentResponseDto("first1", "last1", "name1@mail.com"),
                new StudentResponseDto("first2", "last2", "name2@mail.com"));

        when(studentRepository.findAll()).thenReturn(mockStudentEntities);
        when(studentMapper.toStudentResponseDtos(mockStudentEntities)).thenReturn(mockStudentResponseDtos);

        // When
        List<StudentResponseDto> studentResponseDtos = studentService.findAllStudents();

        // Then
        assertEquals(studentResponseDtos.size(), mockStudentEntities.size());

        verify(studentRepository, times(1)).findAll();
    }

    @Test
    public void shouldFindStudentById() {
        // Given
        Integer id = 1;

        // Mock calls
        StudentEntity mockStudentEntity = new StudentEntity("John", "Doe", "john@mail.com", 20);
        StudentResponseDto mockStudentResponseDto = new StudentResponseDto("John", "Doe", "john@mail.com");

        when(studentRepository.findById(id)).thenReturn(Optional.of(mockStudentEntity));
        when(studentMapper.toStudentResponseDto(mockStudentEntity)).thenReturn(mockStudentResponseDto);

        // When
        StudentResponseDto studentResponseDto = studentService.findStudentById(id);

        // Then
        assertEquals(studentResponseDto.firstname(), mockStudentEntity.getFirstname());
        assertEquals(studentResponseDto.lastname(), mockStudentEntity.getLastname());
        assertEquals(studentResponseDto.email(), mockStudentEntity.getEmail());

        verify(studentRepository, times(1)).findById(id);
        verify(studentMapper, times(1)).toStudentResponseDto(mockStudentEntity);
    }

    @Test
    public void shouldFindStudentsByName() {
        // Given
        String name = "first";

        // Mock calls
        List<StudentEntity> mockStudentEntities = Arrays.asList(
                new StudentEntity("first1", "last1", "name1@mail.com", 20),
                new StudentEntity("first2", "last2", "name2@mail.com", 20));
        List<StudentResponseDto> mockStudentResponseDtos = Arrays.asList(
                new StudentResponseDto("first1", "last1", "name1@mail.com"),
                new StudentResponseDto("first2", "last2", "name2@mail.com"));

        when(studentRepository.findAllByFirstnameContaining(name)).thenReturn(mockStudentEntities);
        when(studentMapper.toStudentResponseDtos(mockStudentEntities)).thenReturn(mockStudentResponseDtos);

        // When
        List<StudentResponseDto> studentResponseDtos = studentService.findStudentsByName(name);

        // Then
        assertEquals(mockStudentEntities.size(), studentResponseDtos.size());

        verify(studentRepository, times(1)).findAllByFirstnameContaining(name);
        verify(studentMapper, times(1)).toStudentResponseDtos(mockStudentEntities);
    }

    @Test
    public void shouldDeleteStudent() {
        // Given
        Integer id = 1;

        // Mock calls

        // When
        studentService.delete(id);

        // Then
        verify(studentRepository, times(1)).deleteById(id);
    }
}