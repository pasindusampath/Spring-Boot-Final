package lk.ijse.gdse63.authenticate.dto;

import java.util.ArrayList;

public class LoginRes {
    private String email;
    private String token;
    private ArrayList<String> roles;

    public LoginRes(String email, String token,ArrayList<String> roles) {
        this.email = email;
        this.token = token;
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ArrayList<String> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<String> roles) {
        this.roles = roles;
    }
}