package main.DTO;

import main.DTO.User.UserDTO;
import main.Entity.User;

public class DTOConverter {
    public static UserDTO convert(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setCpf(user.getCpf());
        userDTO.setAddress(user.getAddress());
        userDTO.setEmail(user.getEmail());
        userDTO.setTelephone(user.getTelephone());
        userDTO.setRegistrationDate(user.getRegistrationDate());
        return userDTO;
    }
}
