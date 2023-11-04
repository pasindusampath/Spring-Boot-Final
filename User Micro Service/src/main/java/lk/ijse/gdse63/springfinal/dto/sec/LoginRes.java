package lk.ijse.gdse63.springfinal.dto.sec;

public class LoginRes {
    int userId;
    private String email;
    private String token;

    public LoginRes(String email, String token,int userId) {
        this.email = email;
        this.token = token;
        this.userId=userId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}