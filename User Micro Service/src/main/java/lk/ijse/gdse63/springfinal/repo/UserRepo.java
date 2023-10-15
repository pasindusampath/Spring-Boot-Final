package lk.ijse.gdse63.springfinal.repo;

import lk.ijse.gdse63.springfinal.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,Integer> {
    User findByEmail(String email);
    void deleteByEmail(String email);
}
