package service;

import model.Post;
import model.User;
import repository.PostRepository;

import java.util.List;
import java.util.Optional;

public class PostService {
    private final PostRepository postRepository = new PostRepository();

    public void addPost(Post post) {
        postRepository.addPost(post);
    }
    public List<Post> getPostByUserId(User user){
        return postRepository.getPostByUserId(user);
    }
}
