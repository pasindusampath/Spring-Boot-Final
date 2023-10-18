package lk.ijse.gdse63.springfinal.api;


import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/guide")
public class GuideAPI {

    @PostMapping
    public void saveGuide(@RequestParam("name")String name,
                          @RequestParam("address")String address,
                          @RequestParam("contact") String contact,
                          @RequestParam("birthDate") LocalDate birthDate,
                          @RequestParam("manDayValue") double manDayValue,
                          @RequestParam("experience") String experience,
                          @RequestParam("guideIdFront") byte[] guideIdFront,
                          @RequestParam("guideIdRear") byte[] guideIdRear,
                          @RequestParam("nicFront") byte[] nicFront,
                          @RequestParam("nicRear") byte[] nicRear,
                          @RequestParam("profilePic") byte[] profilePic) {

    }

    @DeleteMapping
    public void deleteGuide() {

    }

    @PutMapping
    public void updateGuide() {

    }

    @GetMapping
    public void getGuide() {

    }

}
