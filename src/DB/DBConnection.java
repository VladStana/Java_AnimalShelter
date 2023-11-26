package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {

    private static DBConnection DBconn = null;
    private Connection conn = null;

    private DBConnection () {}

    public static DBConnection getInstance() {
        if(DBconn == null)
            DBconn = new DBConnection();
        return DBconn;
    }

    public void startConnection() throws SQLException, ClassNotFoundException {
        if(conn == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/javadb";
            String username = "root";
            String password = "mySQL12345_";

            conn = DriverManager.getConnection(url, username, password);

        }
    }

    public Connection getConn() {
        return conn;
    }
}
