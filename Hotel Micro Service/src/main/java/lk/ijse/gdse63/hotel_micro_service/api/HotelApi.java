package lk.ijse.gdse63.hotel_micro_service.api;

import lk.ijse.gdse63.hotel_micro_service.dto.HotelDTO;
import lk.ijse.gdse63.hotel_micro_service.dto.PricesDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@RestController
@RequestMapping("api/v1/hotel")
public class HotelApi {
    @GetMapping("{hotelId:\\d+}")
    public void getHotel(@PathVariable int hotelId){
        HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setId(hotelId);
        hotelDTO.setName("Hotel 1");
        hotelDTO.setCategory("Hotel");
        hotelDTO.setPetAllowed(true);
        hotelDTO.setMapLink("www.google.com");
        hotelDTO.setAddress("Colombo");
        ArrayList<String> objects = new ArrayList<>();
        Stream.of("0771234567","0771234568").forEach(objects::add);
        hotelDTO.setPhone(objects);
        hotelDTO.setEmail("M5Rq7@example.com");
        hotelDTO.setPrices(new ArrayList<>());
        hotelDTO.setRemarks("Good");
        System.out.println("Get Mapping");
    }

    @PostMapping()
    public ResponseEntity uploadFiles(@RequestParam("files") MultipartFile[] files,
                                      @RequestParam("name") String name,
                                      @RequestParam("category") String category,
                                      @RequestParam("petAllowed") boolean petAllowed,
                                      @RequestParam("mapLink") String mapLink,
                                      @RequestParam("address") String address,
                                      @RequestParam("phone") ArrayList<String> phone,
                                      @RequestParam("email") String email,
                                      @RequestParam("prices") ArrayList<PricesDTO> prices,
                                      @RequestParam("remarks") String remarks) {

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

        return new ResponseEntity(1, HttpStatus.CREATED);
    }

    @PutMapping("/{id:\\d+}")
    public ResponseEntity update(@PathVariable String id,
                       @RequestParam("files") MultipartFile[] files,
                       @RequestParam("name") String name,
                       @RequestParam("category") String category,
                       @RequestParam("petAllowed") boolean petAllowed,
                       @RequestParam("mapLink") String mapLink,
                       @RequestParam("address") String address,
                       @RequestParam("phone") ArrayList<String> phone,
                       @RequestParam("email") String email,
                       @RequestParam("prices") ArrayList<PricesDTO> prices,
                       @RequestParam("remarks") String remarks){


        return new ResponseEntity<>(HttpStatus.OK);
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
