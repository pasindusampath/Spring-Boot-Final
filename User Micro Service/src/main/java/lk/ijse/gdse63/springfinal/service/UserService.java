package lk.ijse.gdse63.springfinal.service;

import lk.ijse.gdse63.springfinal.dto.UserDTO;
import lk.ijse.gdse63.springfinal.exception.DeleteFailException;
import lk.ijse.gdse63.springfinal.exception.UpdateFailException;
import lk.ijse.gdse63.springfinal.exception.UserNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    UserDTO searchUserByEmail(String email) throws UserNotFoundException;
    void updateUser(UserDTO email) throws UpdateFailException;
    void deleteUser(String email) throws DeleteFailException;
    List<UserDTO> getAll(String email) throws UserNotFoundException;
}
