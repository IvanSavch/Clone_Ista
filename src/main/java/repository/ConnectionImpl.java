package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionImpl {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String password = "root";
    private static final String name = "postgres";

    private static Connection connection;

    static {
        try{
            connection = DriverManager.getConnection(url,name,password);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return connection;
    }
}
