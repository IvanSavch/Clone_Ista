package service;

import model.Post;
import repository.PostRepository;

public class PostService {
    private final PostRepository postRepository = new PostRepository();

    public void addPost(Post post) {
        postRepository.addPost(post);
    }
}
