package pro.austincook.learn_spring.basicrestapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pro.austincook.learn_spring.basicrestapi.dto.OrderDto;
import pro.austincook.learn_spring.basicrestapi.dto.OrderRecord;

@RestController
public class FirstController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from my first controller";
    }

    @GetMapping("/hello-2")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String sayHello2() {
        return "Hello 2 from my first controller";
    }

    // path variable
    @GetMapping("/hello/{user-name}")
    public String pathVar(
            @PathVariable("user-name") String userName
    ) {
        return "My path variable: " + userName;
    }

    // param variable "/hello?first-name={firstName}&last-name={lastName}"
    @GetMapping("/hello-3")
    public String paramVar(
            @RequestParam("first-name") String firstName,
            @RequestParam("last-name") String lastName
    ) {
        return "My param variables: firstName: " + firstName + ", lastName: " + lastName;
    }

    // string request body
    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED) // response code on success
    public String post(
            @RequestBody String message // must specify @RequestBody so Spring will inject it
    ) {
        return "Request saved and message is: " + message;
    }

    // JSON request body saved as POJO
    @PostMapping("/post-order-dto")
    @ResponseStatus(HttpStatus.CREATED) // response code on success
    public String postDto(
            @RequestBody OrderDto orderDto // must specify @RequestBody so Spring will inject it
    ) {
        return "Request saved and message is: " + orderDto.toString();
    }

    // JSON request body saved as Java Record
    @PostMapping("/post-order-record")
    @ResponseStatus(HttpStatus.CREATED) // response code on success
    public String postRecord(
            @RequestBody OrderRecord orderRecord // must specify @RequestBody so Spring will inject it
    ) {
        return "Request saved and message is: " + orderRecord.toString();
    }
}
