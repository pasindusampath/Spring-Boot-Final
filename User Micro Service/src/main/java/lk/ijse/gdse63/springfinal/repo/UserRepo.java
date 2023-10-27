package lk.ijse.gdse63.springfinal.repo;

import jakarta.transaction.Transactional;
import lk.ijse.gdse63.springfinal.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;

public interface UserRepo extends CrudRepository<User,Integer> {
    User findByEmail(String email);
    void deleteByEmail(String email);
    @Modifying
    @Transactional
    @Query(value = "update user u set u.profile_pic = ? , u.nic_front_img = ? , " +
            "u.nic_rear_img = ? where u.email = ?",
            nativeQuery = true)
    void updateImages(String profilePic,String nicFrontImg,String nicRearImg, String email);

    @Modifying
    @Query("UPDATE User u SET u.username = :username, u.password = :password, u.usernic =" +
            " :usernic, u.contact = :contact, u.birthday = :birthday, u.gender = :gender, " +
            "u.remarks = :remarks, u.nicFrontImg=:nicFrontImg , u.nicRearImg = :nicRearImg," +
            "u.profilePic =:profilePic WHERE u.email = :email")
    void updateUserInfoByEmail(
            String username,
            String password,
            String usernic,
            String contact,
            String email,
            Date birthday,
            String gender,
            String remarks,
            String nicFrontImg,
            String nicRearImg,
            String profilePic
    );
}
