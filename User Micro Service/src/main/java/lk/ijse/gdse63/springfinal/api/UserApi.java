package lk.ijse.gdse63.springfinal.api;

import lk.ijse.gdse63.springfinal.config.JwtUtil;
import lk.ijse.gdse63.springfinal.dto.AdminDTO;
import lk.ijse.gdse63.springfinal.dto.UserDTO;
import lk.ijse.gdse63.springfinal.dto.sec.ErrorRes;
import lk.ijse.gdse63.springfinal.dto.sec.LoginReq;
import lk.ijse.gdse63.springfinal.dto.sec.LoginRes;
import lk.ijse.gdse63.springfinal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/{id:\\d+}")
    public ResponseEntity search(@PathVariable String id) {
        System.out.println("Search Pressed" + id);
        return new ResponseEntity("Search Pressed" + id, HttpStatus.OK);
    }

    @PostMapping
    public void save(@RequestBody UserDTO userDTO){
        System.out.println("Save Pressed : " + userDTO);
    }


    @PutMapping
    public void update(@RequestBody UserDTO userDTO){
        System.out.println("Update Pressed : "+userDTO);
    }

    @DeleteMapping(value = "/{id:\\d+}")
    public void delete(@PathVariable int id){
        System.out.println("Delete Pressed : "+id);
    }
}
