package pe.edu.pe.onlinebooks.controllers.dto;

public class SimpleUserDTO {
    String username;
    String name;
    String token;

    public SimpleUserDTO(String username, String name, String token) {
        this.username = username;
        this.name = name;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
