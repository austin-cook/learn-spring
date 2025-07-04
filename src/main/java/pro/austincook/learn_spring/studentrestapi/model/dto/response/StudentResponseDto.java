package pro.austincook.learn_spring.studentrestapi.model.dto.response;

public record StudentResponseDto(
        String firstname,
        String lastname,
        String email
) {
}
