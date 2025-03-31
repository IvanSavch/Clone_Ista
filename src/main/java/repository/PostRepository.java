package repository;

import model.Post;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostRepository {
    private final UserRepository userRepository = new UserRepository();

    public void addPost(Post post) {
        Connection connection = ConnectionImpl.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("INSERT into post_tb values (default,?,?,?)");
            statement.setString(1, post.getDescription());
            statement.setBytes(2, post.getPicture());
            statement.setLong(3, post.getUser().getId());
            statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Post> getPostByUserId(User user) {
        Connection connection = ConnectionImpl.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from post_tb p where p.user_id = ?");
            preparedStatement.setLong(1, user.getId());

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Post> postList = new ArrayList<>();
            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String description = resultSet.getString(2);
                byte[] picture = resultSet.getBytes(3);
                long userId = resultSet.getInt(4);
                Optional<User> u = userRepository.getUserById(userId);
                Post post = new Post(id, description, picture, u.get());
                postList.add(post);
            }
            return postList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
