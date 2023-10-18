package lk.ijse.gdse63.vehicle_micro_service.service.impl;

import lk.ijse.gdse63.vehicle_micro_service.dto.DriverDTO;
import lk.ijse.gdse63.vehicle_micro_service.dto.VehicleDTO;
import lk.ijse.gdse63.vehicle_micro_service.service.VehicleService;
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
public class VehicleServiceIMPL implements VehicleService {
    @Override
    public int saveVehicle(VehicleDTO dto) {
        exportImages(dto);
        return 0;
    }

    public void exportImages(VehicleDTO vehicleDTO) {
        ArrayList<byte[]> images = vehicleDTO.getImages();
        String dt = LocalDate.now().toString().replace("-", "_") + "__"
                + LocalTime.now().toString().replace(":", "_");

        ArrayList<String> pathList = new ArrayList<>();

        for (int i = 0; i < images.size(); i++) {
            {
                try {
                    InputStream is = new ByteArrayInputStream(images.get(i));
                    BufferedImage bi = ImageIO.read(is);
                    File outputfile = new File("images/vehicle/" + dt + "_" + i + ".jpg");
                    ImageIO.write(bi, "jpg", outputfile);
                    pathList.add(outputfile.getAbsolutePath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(pathList);
        byte[] licenseImageFront = vehicleDTO.getDriverDTO().getLicenseImageFront();
        byte[] licenseImageRear = vehicleDTO.getDriverDTO().getLicenseImageRear();


        try {
            InputStream is = new ByteArrayInputStream(licenseImageFront);
            BufferedImage bi = ImageIO.read(is);
            File outputfile = new File("images/driver/" + dt + "_front"+ ".jpg");
            ImageIO.write(bi, "jpg", outputfile);
            String absolutePath = outputfile.getAbsolutePath();
            System.out.println(absolutePath);

            InputStream is1 = new ByteArrayInputStream(licenseImageRear);
            BufferedImage bi1 = ImageIO.read(is1);
            File outputfile1 = new File("images/driver/" + dt + "_rear"+ ".jpg");
            ImageIO.write(bi1, "jpg", outputfile1);
            String absolutePath1 = outputfile1.getAbsolutePath();
            System.out.println(absolutePath1);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
