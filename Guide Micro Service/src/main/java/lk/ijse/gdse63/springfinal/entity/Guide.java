package lk.ijse.gdse63.springfinal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String contact;
    private Date birthDate;
    private double manDayValue;
    private String experience;
    private String guideIdFront;
    private String guideIdRear;
    private String nicFront;
    private String nicRear;
    private String profilePic;
}
