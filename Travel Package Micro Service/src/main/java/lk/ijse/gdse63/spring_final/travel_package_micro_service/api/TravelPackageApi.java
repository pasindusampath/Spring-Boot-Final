package lk.ijse.gdse63.spring_final.travel_package_micro_service.api;

import lk.ijse.gdse63.spring_final.travel_package_micro_service.dto.TravelPackageDTO;
import lk.ijse.gdse63.spring_final.travel_package_micro_service.service.TravelPackageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        TravelPackageDTO travelPackageDTO = service.fidById(id);
        return ResponseEntity.ok(travelPackageDTO);
    }

    @GetMapping("/{category:^REGULAR|MID-LEVEL|LUXURY|SUPER LUXURY$}")
    public ResponseEntity getByCategory(@PathVariable String category){
        List<TravelPackageDTO> list = service.findByCategory(category);
        return ResponseEntity.ok(list);
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
