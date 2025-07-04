package pro.austincook.learn_spring.studentrestapi.controller;

import org.springframework.web.bind.annotation.*;
import pro.austincook.learn_spring.studentrestapi.model.dto.SchoolRequestResponseDto;
import pro.austincook.learn_spring.studentrestapi.model.entity.SchoolEntity;
import pro.austincook.learn_spring.studentrestapi.dataaccess.SchoolRepository;
import pro.austincook.learn_spring.studentrestapi.service.SchoolService;
import pro.austincook.learn_spring.studentrestapi.service.util.SchoolMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SchoolController {
    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/schools")
    public SchoolRequestResponseDto createSchool(
            @RequestBody SchoolRequestResponseDto dto
            ) {
        return schoolService.createSchool(dto);
    }

    @GetMapping("/schools")
    public List<SchoolRequestResponseDto> findAllStudents() {
        return schoolService.findAllStudents();
    }
}
