/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webtest.controller;

import com.webtest.dao.DAO;
import com.webtest.model.Book;
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
@WebServlet(urlPatterns = {"/home"})
public class homeController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sql = "SELECT * FROM dbo.[Book]";
        DAO dao = new DAO();
        Connection conn = dao.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Book> books = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getString("id"));
                book.setTitle(rs.getString("title"));
                book.setPrice(rs.getFloat("price"));
                book.setImportPrice(rs.getFloat("importPrice"));
                books.add(book);
            }
        } catch (SQLException e) {}
        req.setAttribute("books", books);
        RequestDispatcher rd = req.getRequestDispatcher("/home.jsp");
        rd.forward(req, resp);
    }
    
}
