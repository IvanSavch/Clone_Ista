package repository;

import model.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostRepository {
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
}
