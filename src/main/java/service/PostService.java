package service;

import model.Post;
import model.User;
import repository.PostRepository;
import repository.PostRepositoryImpl;

import java.util.List;

public class PostService {
    private final PostRepository postRepository = new PostRepositoryImpl();

    public void addPost(Post post) {
        postRepository.addPost(post);
    }
    public List<Post> getPostByUserId(User user){
        return postRepository.getPostByUserId(user);
    }
}
