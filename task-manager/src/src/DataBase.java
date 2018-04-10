/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author eduardo
 */
public class DataBase {

    private static String DB_URL = "jdbc:mysql://localhost:3306/taskmanager?autoReconnect=true&useSSL=false";
    private static String USERNAME = "root";
    private static String PASSWORD = "root";

    public static Connection getConnection() {
        Connection conn;
        try {
            conn = (Connection) DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            return conn;
        } catch (SQLException e) {
            return null;
        }
    }
}
