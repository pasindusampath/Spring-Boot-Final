package lk.ijse.gdse63.springfinal.service;

import lk.ijse.gdse63.springfinal.dto.GuideDTO;

public interface GuidService {
    int saveGuide(GuideDTO guideDTO);
    void updateGuide(GuideDTO guideDTO);
    void deleteGuide(int id);
    GuideDTO getGuide(int id);
}
