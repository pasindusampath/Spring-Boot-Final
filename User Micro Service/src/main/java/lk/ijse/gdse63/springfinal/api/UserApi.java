package lk.ijse.gdse63.springfinal.api;

import lk.ijse.gdse63.springfinal.config.JwtUtil;
import lk.ijse.gdse63.springfinal.dto.AdminDTO;
import lk.ijse.gdse63.springfinal.dto.UserDTO;
import lk.ijse.gdse63.springfinal.dto.sec.ErrorRes;
import lk.ijse.gdse63.springfinal.dto.sec.LoginReq;
import lk.ijse.gdse63.springfinal.dto.sec.LoginRes;
import lk.ijse.gdse63.springfinal.exception.CreateFailException;
import lk.ijse.gdse63.springfinal.exception.DeleteFailException;
import lk.ijse.gdse63.springfinal.exception.UpdateFailException;
import lk.ijse.gdse63.springfinal.exception.UserNotFoundException;
import lk.ijse.gdse63.springfinal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserApi {

    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    UserService userService;
    @Autowired
    private  AuthenticationManager authenticationManager;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/login")
    public ResponseEntity login(@RequestBody LoginReq loginReq)  {
        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReq.getEmail(), loginReq.getPassword()));
            String email = authentication.getName();
            UserDTO user = userService.searchUserByEmail(email);
            String token = jwtUtil.createToken(user);
            LoginRes loginRes = new LoginRes(email,token);
            return ResponseEntity.ok(loginRes);

        }catch (BadCredentialsException e){
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST,"Invalid username or password");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }catch (Exception e){
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @GetMapping(value = "/{id:\\d+}/{email}" )
    public ResponseEntity search(@PathVariable String email){
        try {
            UserDTO userDTO = userService.searchUserByEmail(email);
            return ResponseEntity.ok(userDTO);
        } catch (UserNotFoundException e) {
            ErrorRes errorResponse = new ErrorRes(HttpStatus.NOT_FOUND, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @PostMapping(value = "/{id:\\d+}", consumes = "multipart/form-data")
    public ResponseEntity<UserDTO> save(@RequestPart(value = "profilePic") byte[] profilePic,
                                        @RequestPart(value = "userName")String userName,
                                        @RequestPart(value = "password") String password,
                                        @RequestPart(value = "contact") String contact,
                                        @RequestPart(value = "email") String email,
                                        @RequestPart(value = "birthday") String birthday,
                                        @RequestPart(value = "nicFront") byte[] nicFront,
                                        @RequestPart(value = "nicRear") byte[] nicRear,
                                        @RequestPart(value = "gender") String gender,
                                        @RequestPart(value = "nicNo") String nicNo
    ){
        try {
            UserDTO userDTO = new UserDTO();
            userDTO.setUsername(userName);
            userDTO.setPassword(password);
            userDTO.setContact(contact);
            userDTO.setEmail(email);
            userDTO.setUsernic(nicNo);
            userDTO.setBirthday(LocalDate.parse(birthday));
            userDTO.setGender(gender);
            userDTO.setNicFrontByte(nicFront);
            userDTO.setNicRearByte(nicRear);
            userDTO.setProfilePicByte(profilePic);


            int id = userService.addUsers(userDTO);
            userDTO.setId(id);
            return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
        } catch (CreateFailException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping(value = "/{id:\\d+}")
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO){
        try {
            userService.updateUser(userDTO);
            return new ResponseEntity<>(userDTO,HttpStatus.OK);
        } catch (UpdateFailException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id:\\d+}")
    public ResponseEntity delete(@RequestBody UserDTO userDTO){
        try {
            userService.deleteUser(userDTO.getEmail());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DeleteFailException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
