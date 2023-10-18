package lk.ijse.gdse63.springfinal.api;


import lk.ijse.gdse63.springfinal.dto.GuideDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/guide")
public class GuideAPI {

    @PostMapping
    public ResponseEntity saveGuide(@RequestParam("name")String name,
                                    @RequestParam("address")String address,
                                    @RequestParam("contact") String contact,
                                    @RequestParam("birthDate") LocalDate birthDate,
                                    @RequestParam("manDayValue") double manDayValue,
                                    @RequestParam("experience") String experience,
                                    @RequestPart("guideIdFront") byte[] guideIdFront,
                                    @RequestPart("guideIdRear") byte[] guideIdRear,
                                    @RequestPart("nicFront") byte[] nicFront,
                                    @RequestPart("nicRear") byte[] nicRear,
                                    @RequestPart("profilePic") byte[] profilePic) {

        System.out.println("Name : "+name);
        System.out.println("Address : "+address);
        System.out.println("Contact : "+contact);
        System.out.println("Birth Date : "+birthDate);
        System.out.println("Man Day Value : "+manDayValue);
        System.out.println("Experience : "+experience);
        System.out.println("Guide Id Front : "+guideIdFront);
        System.out.println("Guide Id Rear : "+guideIdRear);
        System.out.println("NIC Front : "+nicFront);
        System.out.println("NIC Rear : "+nicRear);
        System.out.println("Profile Pic : "+profilePic);

        return new ResponseEntity<>(1, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id:\\d+}")
    public ResponseEntity deleteGuide(@PathVariable int id) {
        return ResponseEntity.ok(1);
    }

    @PutMapping("/{id:\\d+}")
    public ResponseEntity updateGuide(@PathVariable int id,
                                      @RequestParam("name")String name,
                                      @RequestParam("address")String address,
                                      @RequestParam("contact") String contact,
                                      @RequestParam("birthDate") LocalDate birthDate,
                                      @RequestParam("manDayValue") double manDayValue,
                                      @RequestParam("experience") String experience,
                                      @RequestPart("guideIdFront") byte[] guideIdFront,
                                      @RequestPart("guideIdRear") byte[] guideIdRear,
                                      @RequestPart("nicFront") byte[] nicFront,
                                      @RequestPart("nicRear") byte[] nicRear,
                                      @RequestPart("profilePic") byte[] profilePic) {

        GuideDTO guideDTO = new GuideDTO();
        guideDTO.setId(id);
        guideDTO.setName(name);
        guideDTO.setAddress(address);
        guideDTO.setContact(contact);
        guideDTO.setBirthDate(birthDate);
        guideDTO.setManDayValue(manDayValue);
        guideDTO.setExperience(experience);
        guideDTO.setGuideIdFront(guideIdFront);
        guideDTO.setGuideIdRear(guideIdRear);
        guideDTO.setNicFront(nicFront);
        guideDTO.setNicRear(nicRear);
        guideDTO.setProfilePic(profilePic);


        return ResponseEntity.ok(guideDTO);

    }

    @GetMapping("/{id:\\d+}")
    public ResponseEntity getGuide(@PathVariable int id) {
        GuideDTO guideDTO = new GuideDTO();
        guideDTO.setId(id);
        guideDTO.setName("Test");
        guideDTO.setAddress("Test");
        guideDTO.setContact("Test");
        guideDTO.setBirthDate(LocalDate.now());
        guideDTO.setManDayValue(1);
        guideDTO.setExperience("Test");
        guideDTO.setGuideIdFront(new byte[]{1,2,3});
        guideDTO.setGuideIdRear(new byte[]{1,2,3});
        guideDTO.setNicFront(new byte[]{1,2,3});
        guideDTO.setNicRear(new byte[]{1,2,3});
        guideDTO.setProfilePic(new byte[]{1,2,3});

        return ResponseEntity.ok(guideDTO);
    }

}
