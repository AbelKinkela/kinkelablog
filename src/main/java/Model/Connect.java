package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static Connection initializeDatabase()
            throws SQLException, ClassNotFoundException
    {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String dbURL = "jdbc:mysql://localhost:3306/KINKELABLOG";
        String dbUsername = "root";
        String dbPassword = "2011butterfly";
        Connection con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        return  con;
    }
}

