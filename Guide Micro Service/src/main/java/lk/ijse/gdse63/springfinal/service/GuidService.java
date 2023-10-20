package lk.ijse.gdse63.springfinal.service;

import lk.ijse.gdse63.springfinal.dto.GuideDTO;
import lk.ijse.gdse63.springfinal.exception.DeleteFailException;
import lk.ijse.gdse63.springfinal.exception.SaveFailException;
import lk.ijse.gdse63.springfinal.exception.UpdateFailException;

public interface GuidService {
    int saveGuide(GuideDTO guideDTO) throws SaveFailException;
    void updateGuide(GuideDTO guideDTO) throws UpdateFailException;
    void deleteGuide(int id) throws DeleteFailException;
    GuideDTO getGuide(int id);
}
