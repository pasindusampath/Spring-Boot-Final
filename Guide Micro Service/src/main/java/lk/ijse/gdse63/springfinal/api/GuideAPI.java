package lk.ijse.gdse63.springfinal.api;


import lk.ijse.gdse63.springfinal.dto.GuideDTO;
import lk.ijse.gdse63.springfinal.exception.SaveFailException;
import lk.ijse.gdse63.springfinal.exception.SearchFailException;
import lk.ijse.gdse63.springfinal.exception.UpdateFailException;
import lk.ijse.gdse63.springfinal.service.GuidService;
import lk.ijse.gdse63.springfinal.service.impl.GuideServiceIMPL;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/guide")
public class GuideAPI {

    GuidService service;

    public GuideAPI(GuidService service) {
        this.service = service;
    }

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

        GuideDTO guideDTO = new GuideDTO();
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
        try {
            int i = service.saveGuide(guideDTO);
            return new ResponseEntity<>(i, HttpStatus.CREATED);
        } catch (SaveFailException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/{id:\\d+}")
    public ResponseEntity deleteGuide(@PathVariable int id) {
        try {
            service.deleteGuide(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
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

        try {
            service.updateGuide(guideDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UpdateFailException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }

    }

    @GetMapping("/{id:\\d+}")
    public ResponseEntity getGuide(@PathVariable int id) {

        try {
            GuideDTO guide = service.getGuide(id);
            return new ResponseEntity<>(guide, HttpStatus.OK);
        } catch (SearchFailException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }

    }

}
