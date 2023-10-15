package lk.ijse.gdse63.springfinal.service.impl;




import lk.ijse.gdse63.springfinal.dto.UserDTO;
import lk.ijse.gdse63.springfinal.entity.User;
import lk.ijse.gdse63.springfinal.exception.DeleteFailException;
import lk.ijse.gdse63.springfinal.exception.UpdateFailException;
import lk.ijse.gdse63.springfinal.exception.UserNotFoundException;
import lk.ijse.gdse63.springfinal.repo.UserRepo;
import lk.ijse.gdse63.springfinal.service.UserService;
import org.json.JSONArray;
import org.json.JSONException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Value("${admin.data}")
    private String adminDataEndPoint;
    private UserRepo userRepo;
    private ModelMapper modelMapper;
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
            UserDTO map = modelMapper.map(byEmail, UserDTO.class);
            map.setNicImgs(jsonStringToArray(byEmail.getNicImgs()));
            return map;
        }catch (Exception e){
            throw new UserNotFoundException("User Not Found");
        }
    }

    @Override
    public void updateUser(UserDTO email) throws UpdateFailException {
        try {
            User user = modelMapper.map(email, User.class);
            userRepo.save(user);
        }catch (Exception e){
            throw new UpdateFailException("Operation Failed",e);
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
}