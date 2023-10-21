package lk.ijse.gdse63.spring_final.travel_package_micro_service.api;

import lk.ijse.gdse63.spring_final.travel_package_micro_service.dto.TravelPackageDTO;
import lk.ijse.gdse63.spring_final.travel_package_micro_service.service.TravelPackageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/travel-package")
public class TravelPackageApi {
    TravelPackageService service;
    public TravelPackageApi(TravelPackageService service){
        this.service = service;
    }
    @PostMapping
    public ResponseEntity save(@RequestBody TravelPackageDTO obj){
        String save = service.save(obj);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/{id:^NEXT-\\d{4}$}")
    public ResponseEntity get(@PathVariable String id){
        TravelPackageDTO travelPackageDTO = new TravelPackageDTO();
        travelPackageDTO.setId(id);
        travelPackageDTO.setHotelCount(2);
        travelPackageDTO.setAreaCount(3);
        travelPackageDTO.setEstimatedPrice(4);
        travelPackageDTO.setCategory("5");
        travelPackageDTO.setDayCount(6);
        return ResponseEntity.ok(travelPackageDTO);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody TravelPackageDTO obj){
        service.update(obj);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id:^NEXT-\\d{4}$}")
    public ResponseEntity delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
