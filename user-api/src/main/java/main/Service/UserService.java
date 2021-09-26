package main.Service;

import main.DTO.UserDTO;
import main.Entity.User;
import main.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAll() {
        List<User> allUsers = userRepository.findAll();
        return allUsers.stream().map(UserDTO :: convert).collect(Collectors.toList());
    }

    public UserDTO findByCpf(String cpf) {
        User user = userRepository.findByCpf(cpf);
        if(Objects.nonNull(user)) {
            return UserDTO.convert(user);
        }
        return null;
    }

    public UserDTO findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(UserDTO::convert).orElse(null);
    }

    public void save(UserDTO userDTO) {
        User user = userRepository.save(User.convert(userDTO));
        UserDTO.convert(user);
    }

    public void delete(Long id) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(value -> userRepository.delete(value));
    }

    public List<UserDTO> findByNameContaining(String name) {
        List<User> users = userRepository.findByNameContaining(name);

        return users.stream().map(UserDTO :: convert).collect(Collectors.toList());
    }
}