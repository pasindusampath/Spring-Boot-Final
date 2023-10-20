package lk.ijse.gdse63.springfinal.service.impl;

import lk.ijse.gdse63.springfinal.dto.GuideDTO;
import lk.ijse.gdse63.springfinal.entity.Guide;
import lk.ijse.gdse63.springfinal.service.GuidService;
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
public class GuideServiceIMPL implements GuidService {
    @Override
    public int saveGuide(GuideDTO guideDTO) {
        return 0;
    }

    @Override
    public void updateGuide(GuideDTO guideDTO) {

    }

    @Override
    public void deleteGuide(int id) {

    }

    @Override
    public GuideDTO getGuide(int id) {
        return null;
    }

    public void exportImages(GuideDTO guideDTO, Guide guide) {
        String dt = LocalDate.now().toString().replace("-", "_") + "__"
                + LocalTime.now().toString().replace(":", "_");
        try {
            InputStream is = new ByteArrayInputStream(guideDTO.getGuideIdFront());
            BufferedImage bi = ImageIO.read(is);
            File outputfile = new File("images/guide/front/" + dt + "_" + ".jpg");
            ImageIO.write(bi, "jpg", outputfile);
            guide.setGuideIdFront(outputfile.getAbsolutePath());

            is = new ByteArrayInputStream(guideDTO.getGuideIdRear());
            bi = ImageIO.read(is);
            outputfile = new File("images/guide/rear/" + dt + "_" + ".jpg");
            ImageIO.write(bi, "jpg", outputfile);
            guide.setGuideIdRear(outputfile.getAbsolutePath());

            is = new ByteArrayInputStream(guideDTO.getNicFront());
            bi = ImageIO.read(is);
            outputfile = new File("images/guide/nic/front/" + dt + "_" + ".jpg");
            ImageIO.write(bi, "jpg", outputfile);
            guide.setNicFront(outputfile.getAbsolutePath());

            is = new ByteArrayInputStream(guideDTO.getNicRear());
            bi = ImageIO.read(is);
            outputfile = new File("images/guide/nic/rear/" + dt + "_" + ".jpg");
            ImageIO.write(bi, "jpg", outputfile);
            guide.setNicRear(outputfile.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
