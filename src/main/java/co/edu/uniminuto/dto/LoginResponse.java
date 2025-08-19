package co.edu.uniminuto.dto;

public class LoginResponse {
    public Integer userId;
    public String username;
    public String email;
    public String role;
    public String status;
    public String token;

    public LoginResponse(Integer userId, String username, String email, String role, String status, String token) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.role = role;
        this.status = status;
        this.token = token;
    }
}