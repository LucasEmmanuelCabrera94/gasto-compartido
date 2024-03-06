package gastocompartido.api.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    /**
     * Test to check if the server is up and running with Authentication. Returns "Hello world".
     *
     * @return         	"Hello world!"
     */
    @GetMapping("/login")
    public String loginUser() {
        return "Hello world!";
    }
}
