/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webtest.dao;

/**
 *
 * @author Admin
 */
public class BookDAO extends DAO {
    private static BookDAO bookDAO;
    
    public static BookDAO getInstance() {
        if (bookDAO == null) {
            bookDAO = new BookDAO();
        }
        return bookDAO;
    }
}
