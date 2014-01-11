/**
 * 
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Maxime Ryckmans
 *
 *
 *Factory for creating connection to MySQL
 */
public class JDBCConnection {
	//static reference to itself
    private static JDBCConnection instance = new JDBCConnection();
    public static final String URL = "jdbc:mysql://localhost:3306/quizdb2";
    public static final String USER = "root";
    public static final String PASSWORD = "root";
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver"; 
 
   
    private JDBCConnection() {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
 
    private Connection createConnection() {
 
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("ERROR: Unable to Connect to Database.");
        }
        return connection;
    }   
 
    public static Connection getConnection() {
        return instance.createConnection();
    }
}
