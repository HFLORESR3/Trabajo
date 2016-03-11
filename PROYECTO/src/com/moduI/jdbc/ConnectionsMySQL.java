package com.moduI.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionsMySQL {

    private static final String url = "jdbc:mysql://localhost:3306/final";
    private static final String user = "root";
    private static final String passwd = "mysql";
    
    private static Connection con;

    public static Connection getInstance() {
        if (con == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException | ClassNotFoundException e) {
            }
        }
        return con;
    }
}
