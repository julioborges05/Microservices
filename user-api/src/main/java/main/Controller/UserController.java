package main.Controller;

import main.DTO.UserDTO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    public List<UserDTO> users = new ArrayList<UserDTO>();

    @PostConstruct
    public void initiateList() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Eduardo");
        userDTO.setCpf("123");
        userDTO.setAddress("Rua a");
        userDTO.setEmail("eduardo@email.com");
        userDTO.setTelephone("1234-3454");
        userDTO.setRegistrationDate(new Date());

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setName("Luiz");
        userDTO2.setCpf("456");
        userDTO2.setAddress("Rua b");
        userDTO2.setEmail("luiz@email.com");
        userDTO2.setTelephone("1234-3454");
        userDTO2.setRegistrationDate(new Date());

        UserDTO userDTO3 = new UserDTO();
        userDTO3.setName("Bruna");
        userDTO3.setCpf("678");
        userDTO3.setAddress("Rua c");
        userDTO3.setEmail("bruna@email.com");
        userDTO3.setTelephone("1234-3454");
        userDTO3.setRegistrationDate(new Date());

        users.add(userDTO);
        users.add(userDTO2);
        users.add(userDTO3);
    }

    @GetMapping("/user")
    public List<UserDTO> getUsers() {
        return users;
    }

    @GetMapping("/user/{cpf}")
    public UserDTO getSpecificUserByCpf(@PathVariable String cpf) {
        for(UserDTO user : users) {
            if(user.getCpf().equals(cpf)) {
                return user;
            }
        }
        return null;
    }

    @PostMapping("/newUserData")
    public UserDTO insertUser(@RequestBody UserDTO newUserRequest) {
        newUserRequest.setRegistrationDate(new Date());
        users.add(newUserRequest);
        return newUserRequest;
    }

    @DeleteMapping("/user/{cpf}")
    public boolean removeUser(@PathVariable String cpf) {
        for(UserDTO user : users) {
            if(user.getCpf().equals(cpf)) {
                users.remove(user);
                return true;
            }
        }
        return false;
    }
}
