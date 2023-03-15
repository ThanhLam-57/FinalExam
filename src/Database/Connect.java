package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import Config.Config;

public class Connect {
    private static Connect connect = null;
    private static String url = Config.DB_URL;
    private static String username = Config.USER_NAME;
    private static String password = Config.PASSWORD;
    private Connect() {

    }
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static Connect getInstance() {
        return connect == null ? new Connect() : connect;
    }
}
