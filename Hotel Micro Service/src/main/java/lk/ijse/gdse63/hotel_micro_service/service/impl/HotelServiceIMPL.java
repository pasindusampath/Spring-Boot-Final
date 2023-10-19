package lk.ijse.gdse63.hotel_micro_service.service.impl;

import com.google.gson.Gson;
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
}
