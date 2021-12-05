/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webtest.model;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Book implements Serializable {
    private String id;
    private String title;
    private float price;
    private float importPrice;

    public Book() {
    }

    public Book(String id, String title, float price, float importPrice) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.importPrice = importPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }
    
    
}
