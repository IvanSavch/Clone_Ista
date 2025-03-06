package model;

import lombok.Data;
import lombok.Lombok;

@Data
public class User {
    private Long id;
    private String name;
    private String userName;
    private String password;

    public User(String name, String userName, String password) {
        this.name = name;
        this.userName = userName;
        this.password = password;
    }
}
