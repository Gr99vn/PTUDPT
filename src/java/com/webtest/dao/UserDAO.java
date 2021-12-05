/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webtest.dao;

import com.webtest.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class UserDAO extends DAO {
    private static UserDAO userDAO;
    
    public static UserDAO getInstance() {
        if (userDAO == null) {
            userDAO = new UserDAO();
        }
        return userDAO;
    }
    
    public boolean checkLogin(User user) {
        Connection conn = getConnection();
        String sql = "SELECT * FROM dbo.[STAFF] WHERE username = ? AND password = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
