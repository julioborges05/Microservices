package main.Controller;

import main.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/")
    public List<UserDTO> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/user/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/user/cpf/{cpf}")
    public UserDTO getSpecificUserByCpf(@PathVariable String cpf) {
        return userService.findByCpf(cpf);
    }

    @GetMapping("/user/search")
    public List<UserDTO> queryByName(@RequestParam(name="name", required = true) String name) {
        return userService.findByNameContaining(name);
    }

    @PostMapping("/user")
    public UserDTO insertNewUser(@RequestBody UserDTO newUserRequest) {
        userService.save(newUserRequest);
        return newUserRequest;
    }

    @DeleteMapping("/user/{id}")
    public UserDTO deleteById(@PathVariable Long id) {
        userService.delete(id);
        return userService.findById(id);
    }
}