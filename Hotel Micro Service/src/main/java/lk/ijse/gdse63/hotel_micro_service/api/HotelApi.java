package lk.ijse.gdse63.hotel_micro_service.api;

import lk.ijse.gdse63.hotel_micro_service.dto.HotelDTO;
import lk.ijse.gdse63.hotel_micro_service.dto.PricesDTO;
import lk.ijse.gdse63.hotel_micro_service.exception.NotFoundException;
import lk.ijse.gdse63.hotel_micro_service.exception.SaveFailException;
import lk.ijse.gdse63.hotel_micro_service.exception.UpdateFailException;
import lk.ijse.gdse63.hotel_micro_service.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@RestController
@RequestMapping("api/v1/hotel")
public class HotelApi {

    private HotelService hotelService;

    public HotelApi(HotelService hotelService){
        this.hotelService = hotelService;
    }

    @GetMapping("{hotelId:\\d+}")
    public ResponseEntity getHotel(@PathVariable int hotelId){
        try {
            HotelDTO search = hotelService.search(hotelId);
            return ResponseEntity.ok(search);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity uploadFiles(@RequestParam("files") ArrayList<MultipartFile> files,
                                      @RequestParam("name") String name,
                                      @RequestParam("category") String category,
                                      @RequestParam("petAllowed") boolean petAllowed,
                                      @RequestParam("mapLink") String mapLink,
                                      @RequestParam("address") String address,
                                      @RequestParam("phone") ArrayList<String> phone,
                                      @RequestParam("email") String email,
                                      @RequestParam("prices") ArrayList<PricesDTO> prices,
                                      @RequestParam("remarks") String remarks) {

        ArrayList<byte[]> bytes = new ArrayList<>();
        files.forEach(file -> {
            try {
                bytes.add(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setName(name);
        hotelDTO.setCategory(category);
        hotelDTO.setPetAllowed(petAllowed);
        hotelDTO.setMapLink(mapLink);
        hotelDTO.setAddress(address);
        hotelDTO.setPhone(phone);
        hotelDTO.setEmail(email);
        hotelDTO.setPrices(prices);
        hotelDTO.setRemarks(remarks);
        hotelDTO.setImages(bytes);

        try {
            int save = hotelService.save(hotelDTO);
            return new ResponseEntity(save, HttpStatus.CREATED);
        } catch (SaveFailException e) {
            e.printStackTrace();
            return new ResponseEntity("Request Fail", HttpStatus.BAD_REQUEST);
        }


    }

    @PutMapping("/{id:\\d+}")
    public ResponseEntity update(@PathVariable String id,
                       @RequestParam("files") ArrayList<MultipartFile> files,
                       @RequestParam("name") String name,
                       @RequestParam("category") String category,
                       @RequestParam("petAllowed") boolean petAllowed,
                       @RequestParam("mapLink") String mapLink,
                       @RequestParam("address") String address,
                       @RequestParam("phone") ArrayList<String> phone,
                       @RequestParam("email") String email,
                       @RequestParam("prices") ArrayList<PricesDTO> prices,
                       @RequestParam("remarks") String remarks){
        HotelDTO hotelDTO = new HotelDTO();
        ArrayList<byte[]> bytes = new ArrayList<>();
        files.forEach(file -> {
            try {
                bytes.add(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        hotelDTO.setName(name);
        hotelDTO.setCategory(category);
        hotelDTO.setPetAllowed(petAllowed);
        hotelDTO.setMapLink(mapLink);
        hotelDTO.setAddress(address);
        hotelDTO.setPhone(phone);
        hotelDTO.setEmail(email);
        hotelDTO.setPrices(prices);
        hotelDTO.setRemarks(remarks);
        hotelDTO.setImages(bytes);
        try {
            hotelService.update(hotelDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UpdateFailException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/{id:\\d+}")
    public ResponseEntity delete(@PathVariable String id){
        System.out.println(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{starRate:^Star-[2-5]$}")
    public ResponseEntity getByStarRate(@PathVariable String starRate){
        int star = Integer.parseInt((starRate.split("-"))[1]);
        System.out.println(star);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAll(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
