package lk.ijse.gdse63.spring_final.travel_package_micro_service.service.impl;

import lk.ijse.gdse63.spring_final.travel_package_micro_service.dto.TravelPackageDTO;
import lk.ijse.gdse63.spring_final.travel_package_micro_service.entity.TravelPackage;
import lk.ijse.gdse63.spring_final.travel_package_micro_service.repo.TravelPackageRepo;
import lk.ijse.gdse63.spring_final.travel_package_micro_service.service.TravelPackageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

@Service
public class TravelPackageServiceIMPL implements TravelPackageService {
    TravelPackageRepo travelPackageRepo;
    ModelMapper modelMapper;



    public TravelPackageServiceIMPL(TravelPackageRepo travelPackageRepo,
                                    ModelMapper modelMapper) {
        this.travelPackageRepo = travelPackageRepo;
        this.modelMapper = modelMapper;

    }

    @Override
    public String save(TravelPackageDTO obj) {
        String id = generateNextId();
        obj.setId(id);
        TravelPackage map = modelMapper.map(obj, TravelPackage.class);
        TravelPackage save = travelPackageRepo.save(map);
        return save.getId();
    }

    @Override
    public void update(TravelPackageDTO obj) {
        TravelPackage map = modelMapper.map(obj, TravelPackage.class);
        travelPackageRepo.save(map);
    }

    @Override
    public void delete(String id) {
        travelPackageRepo.deleteById(id);
    }

    @Override
    public List<TravelPackageDTO> getPackagesByCategory(String category) {
        return null;
    }

    @Override
    public TravelPackageDTO fidById(String id) {
        Optional<TravelPackage> byId = travelPackageRepo.findById(id);
        if (byId.isPresent()) {
            return modelMapper.map(byId.get(), TravelPackageDTO.class);
        }
        return null;
    }

    @Override
    public List<TravelPackageDTO> findByCategory(String category) {
        List<TravelPackage> byCategory = travelPackageRepo.findByCategory(category);
        ArrayList<TravelPackageDTO> list = modelMapper.map(byCategory, new TypeToken<ArrayList<TravelPackageDTO>>() {
        }.getType());
        return list;
    }

    @Override
    public String generateNextId() {
        ArrayList<String> ids = new ArrayList<>();
        TreeSet<Integer> numarical = new TreeSet<>();
        List<TravelPackage> all = travelPackageRepo.findAll();
        all.stream().map(TravelPackage::getId).forEach(ids::add);
        ids.forEach(e->{
            numarical.add(Integer.parseInt(e.split("NEXT-")[1]));
        });

        return String.format("NEXT-%05d", numarical.last() + 1);

    }
}
