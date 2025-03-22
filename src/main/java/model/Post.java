package model;

import lombok.Data;

import java.util.PrimitiveIterator;

@Data
public class Post {
    private Long id;
    private String description;
    private byte[] picture;
    private User user;

    public Post(String description, byte[] picture, User user) {
        this.description = description;
        this.picture = picture;
        this.user = user;
    }
}
