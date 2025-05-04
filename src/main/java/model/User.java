package model;

import lombok.Data;
import lombok.Lombok;

import java.util.List;

@Data
public class User {
    private Long id;
    private String name;
    private String userName;
    private String password;
    private byte[] profilePhoto;
    private List<Post> posts;
    private List<String> subscriptions;
    private List<String> subscribers;

    public User(String name, String userName, String password) {
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

    public User(Long id, String name, String userName, String password) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
    }
}
