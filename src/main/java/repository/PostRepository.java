package repository;

import model.Post;
import model.User;

import java.util.List;

public interface PostRepository {
    void addPost(Post post);
    List<Post> getPostByUserId(User user);
}
