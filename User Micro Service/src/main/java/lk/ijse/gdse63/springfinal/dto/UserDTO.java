package lk.ijse.gdse63.springfinal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private int id;
    private String username;
    private String password;
    private String usernic;
    private String contact;
    private String email;
    private LocalDate birthday;
    private ArrayList<String> nicImgs;
    private String gender;
    private String remarks;
}
