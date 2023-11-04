package lk.ijse.gdse63.spring_final.user_travel_package_micro_service.service.impl;

import lk.ijse.gdse63.spring_final.user_travel_package_micro_service.dto.PaymentDTO;
import lk.ijse.gdse63.spring_final.user_travel_package_micro_service.dto.UserTravelPackageDTO;
import lk.ijse.gdse63.spring_final.user_travel_package_micro_service.entity.*;
import lk.ijse.gdse63.spring_final.user_travel_package_micro_service.exception.SaveFailException;
import lk.ijse.gdse63.spring_final.user_travel_package_micro_service.repo.PaymentRepo;
import lk.ijse.gdse63.spring_final.user_travel_package_micro_service.repo.UserTravelPackageRepo;
import lk.ijse.gdse63.spring_final.user_travel_package_micro_service.service.UserTravelPackageService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.stream.Collectors;

@Service
public class UserTravelPackageServiceImpl implements UserTravelPackageService {

    private ModelMapper mapper;
    private UserTravelPackageRepo repo;
    private PaymentRepo paymentRepo;
    public UserTravelPackageServiceImpl(ModelMapper mapper, UserTravelPackageRepo repo,PaymentRepo paymentRepo) {
        this.mapper = mapper;
        this.repo = repo;
        this.paymentRepo = paymentRepo;
    }
    public int save(UserTravelPackageDTO ob) throws SaveFailException {
        try {
            UserTravelPackage map = mapper.map(ob, UserTravelPackage.class);
            map.setHotels(ob.getHotels().stream().map(e->{
                Hotel hotel = new Hotel();
                hotel.setHotelId(e);
                hotel.setUserTravelPackage(map);
                return hotel;
            }).collect(Collectors.toList()));
            map.setPlaces(ob.getPlaces().stream().map(e->{
                Place place = new Place();
                place.setPlace(e);
                place.setUserTravelPackage(map);
                return place;
            }).collect(Collectors.toList()));
            map.setVehicles(ob.getVehicles().stream().map(e->{
                Vehicle vehicle = new Vehicle();
                vehicle.setVehicleId(e);
                vehicle.setUserTravelPackage(map);
                return vehicle;
            }).collect(Collectors.toList()));
            UserTravelPackage save = repo.save(map);
            return save.getId();
        }catch (Exception e){
            throw new SaveFailException("Operation Fail",e);
        }
    }
    public void savePaymentData(PaymentDTO paymentDTO){
        UserTravelPackage utp = new UserTravelPackage();
        utp.setId(paymentDTO.getUserTravelPackageId());
        Payment payment = new Payment();
        payment.setAmount(paymentDTO.getAmount());
        exportImage(paymentDTO.getPaymentSlip(),payment);
        payment.setApproved(paymentDTO.isApproved());
        payment.setUserTravelPackage(utp);
        paymentRepo.save(payment);
    }

    private void exportImage(byte[] paymentSlip, Payment payment) {
        InputStream is = new ByteArrayInputStream(paymentSlip);
        String n =LocalDate.now().toString().replace("-","_")+
                LocalTime.now().toString().replace(":","_")+".jpg";
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(is);
            File outputfile = new File("images/payment/"+n+ ".jpg");
            ImageIO.write(bi, "jpg", outputfile);
            payment.setPaymentSlip(outputfile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
