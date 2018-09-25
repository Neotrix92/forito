package foro;

import java.io.IOException;
import java.sql.*;

public class DB {

    private static DB db = null;
    private static String dbUrl = "jdbc:mysql://localhost/forito";
    private static String user = "root";
    private static String pass = "";
    public static DB getInstance() throws ClassNotFoundException, IOException, SQLException {
        if (db == null) {
            db = new DB();
        }
        return db;
    }
    private DB() throws ClassNotFoundException,
            IOException, SQLException {
    }

    public Connection getConnection() throws ClassNotFoundException,
            IOException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(dbUrl, user, pass);
    }

}
