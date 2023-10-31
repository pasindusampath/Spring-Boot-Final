package lk.ijse.gdse63.spring_final.travel_package_micro_service.api;

import lk.ijse.gdse63.spring_final.travel_package_micro_service.dto.TravelPackageDTO;
import lk.ijse.gdse63.spring_final.travel_package_micro_service.exception.DeleteFailException;
import lk.ijse.gdse63.spring_final.travel_package_micro_service.exception.NotFoundException;
import lk.ijse.gdse63.spring_final.travel_package_micro_service.exception.SaveFailException;
import lk.ijse.gdse63.spring_final.travel_package_micro_service.exception.UpdateFailException;
import lk.ijse.gdse63.spring_final.travel_package_micro_service.service.TravelPackageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/travel-package")
@CrossOrigin
public class TravelPackageApi {
    TravelPackageService service;
    public TravelPackageApi(TravelPackageService service){
        this.service = service;
    }
    @PostMapping
    public ResponseEntity save(@RequestBody TravelPackageDTO obj){
        String save = null;
        try {
            save = service.save(obj);
            return ResponseEntity.ok(save);
        } catch (SaveFailException e) {
            return new ResponseEntity("Operation Fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{id:^NEXT-\\d{5}$}")
    public ResponseEntity get(@PathVariable String id){
        try {
            TravelPackageDTO travelPackageDTO = service.fidById(id);
            return ResponseEntity.ok(travelPackageDTO);
        }catch (NotFoundException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{category:^REGULAR|MID-LEVEL|LUXURY|SUPER LUXURY$}")
    public ResponseEntity getByCategory(@PathVariable String category){
        try {
            List<TravelPackageDTO> list  = service.findByCategory(category);
            return ResponseEntity.ok(list);
        } catch (NotFoundException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping
    public ResponseEntity update(@RequestBody TravelPackageDTO obj){
        try {
            service.update(obj);
            return ResponseEntity.ok().build();
        } catch (UpdateFailException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/{id:^NEXT-\\d{5}$}")
    public ResponseEntity delete(@PathVariable String id){
        try {
            service.delete(id);
            return ResponseEntity.ok().build();
        } catch (DeleteFailException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
