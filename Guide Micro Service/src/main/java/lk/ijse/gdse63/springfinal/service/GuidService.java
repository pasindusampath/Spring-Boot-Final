package lk.ijse.gdse63.springfinal.service;

import lk.ijse.gdse63.springfinal.dto.GuideDTO;
import lk.ijse.gdse63.springfinal.exception.SaveFailException;

public interface GuidService {
    int saveGuide(GuideDTO guideDTO) throws SaveFailException;
    void updateGuide(GuideDTO guideDTO);
    void deleteGuide(int id);
    GuideDTO getGuide(int id);
}
