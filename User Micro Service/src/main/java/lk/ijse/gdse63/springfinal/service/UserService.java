package lk.ijse.gdse63.springfinal.service;

import lk.ijse.gdse63.springfinal.dto.UserDTO;
import lk.ijse.gdse63.springfinal.exception.UserNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDTO searchUserByEmail(String email) throws UserNotFoundException;
}
