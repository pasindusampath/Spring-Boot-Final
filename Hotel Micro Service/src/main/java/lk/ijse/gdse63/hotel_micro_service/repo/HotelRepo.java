package lk.ijse.gdse63.hotel_micro_service.repo;

import lk.ijse.gdse63.hotel_micro_service.entity.Hotel;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepo extends CrudRepository<Hotel,Integer> {
}
