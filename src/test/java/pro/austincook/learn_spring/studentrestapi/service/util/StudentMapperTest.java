package pro.austincook.learn_spring.studentrestapi.service.util;

import org.junit.jupiter.api.*;
import pro.austincook.learn_spring.studentrestapi.model.dto.request.StudentRequestDto;
import pro.austincook.learn_spring.studentrestapi.model.dto.response.StudentResponseDto;
import pro.austincook.learn_spring.studentrestapi.model.entity.StudentEntity;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {
    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentRequestDtoToStudentEntity() {
        StudentRequestDto dto = new StudentRequestDto("John", "Doe", "john@mail.com", 1);
        StudentEntity studentEntity = mapper.toStudentEntity(dto);

        assertEquals(dto.firstname(), studentEntity.getFirstname());
        assertEquals(dto.lastname(), studentEntity.getLastname());
        assertEquals(dto.email(), studentEntity.getEmail());
        assertNotNull(studentEntity.getSchoolEntity());
        assertEquals(dto.schoolId(), studentEntity.getSchoolEntity().getId());
    }

    @Test
    public void givenNullStudentRequestDto_whenToStudentEntity_thenThrowNullPointerException() {
        NullPointerException exp = assertThrows(NullPointerException.class, () -> mapper.toStudentEntity(null));
        assertEquals("The StudentRequestDto is null", exp.getMessage());
    }

    @Test
    public void shouldMapStudentEntityToStudentResponseDto() {
        StudentEntity studentEntity = new StudentEntity("John", "Doe", "john@mail.com", 20);
        StudentResponseDto dto = mapper.toStudentResponseDto(studentEntity);

        assertEquals("John", dto.firstname());
        assertEquals("Doe", dto.lastname());
        assertEquals("john@mail.com", dto.email());
    }
}