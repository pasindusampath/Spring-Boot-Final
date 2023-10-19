package lk.ijse.gdse63.hotel_micro_service.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lk.ijse.gdse63.hotel_micro_service.dto.HotelDTO;
import lk.ijse.gdse63.hotel_micro_service.entity.Hotel;
import lk.ijse.gdse63.hotel_micro_service.exception.SaveFailException;
import lk.ijse.gdse63.hotel_micro_service.exception.UpdateFailException;
import lk.ijse.gdse63.hotel_micro_service.repo.HotelRepo;
import lk.ijse.gdse63.hotel_micro_service.service.HotelService;
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
import java.util.ArrayList;
import java.util.Optional;

@Service
public class HotelServiceIMPL implements HotelService {

    private Gson gson;
    private ModelMapper modelMapper;
    private HotelRepo hotelRepo;
    public HotelServiceIMPL(Gson gson, ModelMapper modelMapper, HotelRepo hotelRepo) {
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.hotelRepo = hotelRepo;
    }
    @Override
    public int save(HotelDTO hotelDTO) throws SaveFailException {
        try {
            Hotel map = modelMapper.map(hotelDTO, Hotel.class);
            map.setPhone(gson.toJson(hotelDTO.getPhone()));
            map.setPrices(gson.toJson(hotelDTO.getPrices()));
            exportImages(hotelDTO,map);
            return hotelRepo.save(map).getId();
        }catch (Exception e){
            throw new SaveFailException("Save Fail ",e);
        }
    }

    @Override
    public void update(HotelDTO hotelDTO) throws UpdateFailException {
        try {
            Optional<Hotel> byId = hotelRepo.findById(hotelDTO.getId());
            if (byId.isPresent()){
                deleteImages(byId);
                Hotel map = modelMapper.map(hotelDTO, Hotel.class);
                map.setPhone(gson.toJson(hotelDTO.getPhone()));
                map.setPrices(gson.toJson(hotelDTO.getPrices()));
                exportImages(hotelDTO,map);
                hotelRepo.save(map);
            }
        }catch (Exception e){
            throw new UpdateFailException("Update Fail ",e);
        }
    }

    public void exportImages(HotelDTO hotelDTO, Hotel hotel) {
        ArrayList<byte[]> images = hotelDTO.getImages();
        String dt = LocalDate.now().toString().replace("-", "_") + "__"
                + LocalTime.now().toString().replace(":", "_");

        ArrayList<String> pathList = new ArrayList<>();

        for (int i = 0; i < images.size(); i++) {
            {
                try {
                    InputStream is = new ByteArrayInputStream(images.get(i));
                    BufferedImage bi = ImageIO.read(is);
                    File outputfile = new File("images/hotels/" + dt + "_" + i + ".jpg");
                    ImageIO.write(bi, "jpg", outputfile);
                    pathList.add(outputfile.getAbsolutePath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        hotel.setImages(gson.toJson(pathList));


    }

    private void deleteImages(Optional<Hotel> byId) {
        if (byId.isPresent()){
            if (byId.isPresent()){
                Hotel hotel = byId.get();
                String images = hotel.getImages();
                if (images != null){
                    ArrayList<String> pathList = gson.fromJson(images, new TypeToken<ArrayList<String>>(){}.getType());
                    for (String path : pathList) {
                        File file = new File(path);
                        boolean delete = file.delete();
                        System.out.println("Images " + delete);
                    }
                }
            }
        }
    }
}
