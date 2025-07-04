package pro.austincook.learn_spring.studentrestapi.model.dto.request;

import jakarta.validation.constraints.NotBlank;

public record StudentRequestDto(
        @NotBlank
        String firstname,
        @NotBlank(message = "lastname must not be blank")
        String lastname,
        String email,
        Integer schoolId
) {
}
