package com.moduI.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Henry
 */
public class ConnectionsORA {
    
    private static final String url = "jdbc:oracle:thin:@Armando-PC:1521:XE";
    private static final String user = "eureka";
    private static final String passwd = "admin";
    
    private static Connection con;

    public static Connection getInstance() {
        if (con == null) {
            try {
                Class.forName("oracle.jdbc.OracleDriver");
                con = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException | ClassNotFoundException e) {
            }
        }
        return con;
    }
}
