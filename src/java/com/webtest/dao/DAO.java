/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DAO {
    private final String USER = "sa";
    private final String PASSWORD = "123456";
    private final String INSTANCE = "GHOSTMACHINE\\SQLSERVER_REPL1:1433";
    private final String DBNAME = "duc_store";
    public Connection getConnection() {
        String url = String.format("jdbc:sqlserver://%s;databaseName=%s;", INSTANCE, DBNAME);
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(url, USER, PASSWORD);
            return conn;
        } catch (SQLException | ClassNotFoundException e ) {
            e.printStackTrace();
            return null;
        }
    }
}
