package lk.ijse.gdse63.authenticate.service;

import lk.ijse.gdse63.authenticate.dto.AdminDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AdminService extends UserDetailsService {
    AdminDTO searchUser(String email);
}
