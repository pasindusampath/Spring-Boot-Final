package lk.ijse.gdse63.springfinal.service.impl;




import jakarta.transaction.Transactional;
import lk.ijse.gdse63.springfinal.dto.UserDTO;
import lk.ijse.gdse63.springfinal.entity.User;
import lk.ijse.gdse63.springfinal.exception.CreateFailException;
import lk.ijse.gdse63.springfinal.exception.DeleteFailException;
import lk.ijse.gdse63.springfinal.exception.UpdateFailException;
import lk.ijse.gdse63.springfinal.exception.UserNotFoundException;
import lk.ijse.gdse63.springfinal.repo.UserRepo;
import lk.ijse.gdse63.springfinal.service.UserService;
import org.json.JSONArray;
import org.json.JSONException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Value("${admin.data}")
    private String adminDataEndPoint;
    private final UserRepo userRepo;

    private final ModelMapper modelMapper;
    public UserServiceImpl (UserRepo userRepo,ModelMapper mapper){
        this.userRepo = userRepo;
        this.modelMapper = mapper;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);
        System.out.println(user);
        List<String> roles = new ArrayList<>();
        roles.add("user");
        UserDetails userDetails =
                org.springframework.security.core.userdetails.User.builder()
                        .username(user.getEmail())
                        .password(user.getPassword())
                        .roles(roles.toArray(new String[1]))
                        .build();
        return userDetails;
    }

    @Override
    public UserDTO searchUserByEmail(String email) throws UserNotFoundException {
        try {
            User byEmail = userRepo.findByEmail(email);
            System.out.println(byEmail);
            UserDTO map = modelMapper.map(byEmail, UserDTO.class);
            map.setBirthday(byEmail.getBirthday().toLocalDate());
            importImages(byEmail,map);
            //map.setNicImgs(jsonStringToArray(byEmail.getNicImgs()));
            return map;
        }catch (Exception e){
            e.printStackTrace();
            throw new UserNotFoundException("User Not Found");
        }
    }

    @Override
    public void updateUser(UserDTO email) throws UpdateFailException {
        try {
            User user = modelMapper.map(email, User.class);
            userRepo.updateUserInfoByEmail(user.getUsername(),user.getPassword(), user.getUsernic(), user.getContact(),
                    user.getEmail(), user.getBirthday(), user.getGender(), user.getRemarks());
        }catch (Exception e){
            throw new UpdateFailException("Operation Failed",e);
        }
    }

    @Override
    @Transactional
    public int addUsers(UserDTO userDTO) throws CreateFailException {
        try {
            User user = modelMapper.map(userDTO, User.class);
            User save = userRepo.save(user);
            exportImages(userDTO,user);
            userRepo.updateImages(save.getProfilePic(),save.getNicFrontImg(),save.getNicRearImg(),save.getEmail());
            return save.getId();
        }catch (Exception e){
            throw new CreateFailException("Operation Failed",e);
        }
    }

    @Override
    public void deleteUser(String email) throws DeleteFailException {
        try {
            userRepo.deleteByEmail(email);
        }catch (Exception e){
            throw new DeleteFailException("Operation Failed",e);
        }
    }

    @Override
    public List<UserDTO> getAll(String email) throws UserNotFoundException {
        return null;
    }

    ArrayList<String> jsonStringToArray(String jsonString) throws JSONException {
        ArrayList<String> stringArray = new ArrayList<String>();
        JSONArray jsonArray = new JSONArray(jsonString);
        for (int i = 0; i < jsonArray.length(); i++) {
            stringArray.add(jsonArray.getString(i));
        }
        return stringArray;
    }

    public void exportImages(UserDTO userDTO,User user) throws IOException {
        String dt = LocalDate.now().toString().replace("-", "_") + "__"
                + LocalTime.now().toString().replace(":", "_");

        InputStream is = new ByteArrayInputStream(userDTO.getProfilePicByte());
        BufferedImage bi = ImageIO.read(is);
        File outputfile = new File("images/user/pro_pic/"+dt+ ".jpg");
        ImageIO.write(bi, "jpg", outputfile);
        user.setProfilePic(outputfile.getAbsolutePath());

        InputStream is1 = new ByteArrayInputStream(userDTO.getNicFrontByte());
        BufferedImage bi1 = ImageIO.read(is1);
        File outputfile1 = new File("images/user/nic_front/"+dt+ ".jpg");
        ImageIO.write(bi1, "jpg", outputfile1);
        user.setNicFrontImg(outputfile1.getAbsolutePath());

        InputStream is2 = new ByteArrayInputStream(userDTO.getNicRearByte());
        BufferedImage bi2 = ImageIO.read(is2);
        File outputfile2 = new File("images/user/nic_rear/"+dt+ ".jpg");
        ImageIO.write(bi2, "jpg", outputfile2);
        user.setNicRearImg(outputfile2.getAbsolutePath());
    }


    public void importImages(User user,UserDTO userDTO) throws IOException {
        BufferedImage read = ImageIO.read(new File(user.getProfilePic()));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(read, "jpg", baos);
        byte[] bytes = baos.toByteArray();
        userDTO.setProfilePic(Base64.getEncoder().encodeToString(bytes));

        read = ImageIO.read(new File(user.getNicFrontImg()));
        baos = new ByteArrayOutputStream();
        ImageIO.write(read, "jpg", baos);
        bytes = baos.toByteArray();
        userDTO.setNicFront(Base64.getEncoder().encodeToString(bytes));
        userDTO.setNicFrontByte(bytes);

        read = ImageIO.read(new File(user.getNicRearImg()));
        baos = new ByteArrayOutputStream();
        ImageIO.write(read, "jpg", baos);
        bytes = baos.toByteArray();
        userDTO.setNicRear(Base64.getEncoder().encodeToString(bytes));
        userDTO.setNicRearByte(bytes);
    }

}