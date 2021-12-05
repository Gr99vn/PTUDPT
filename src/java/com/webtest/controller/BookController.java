/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webtest.controller;

import com.webtest.dao.DAO;
import com.webtest.dao.UserDAO;
import com.webtest.model.Book;
import com.webtest.model.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(urlPatterns = {"/add_book"})
public class BookController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String title = req.getParameter("title");
        float price = Float.parseFloat(req.getParameter("price"));
        float importPrice = Float.parseFloat(req.getParameter("importPrice"));
        
//        Book book = new Book(id, title, price, importPrice);
        
        String sql = "INSERT INTO Book (id, title, price, importPrice) VALUES(?, ?, ?, ?)";
        DAO dao = new DAO();
        Connection conn = dao.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, title);
            ps.setFloat(3, price);
            ps.setFloat(4, importPrice);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        resp.sendRedirect(req.getContextPath() + "/home");
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/add_book.jsp");
        rd.forward(req, resp);
    }
    
}
