/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.javaclasses;

import java.util.Date;

/**
 *
 * @author trainee
 */
public class BookingRequestBean {

    private String name;
    private String VegetableName;
    private int vegetableQuantity;
    private String UserId;
    private String status;
    private String date;
    private int bookingQuantity;

    public int getBookingQuantity() {
        return bookingQuantity;
    }

    public void setBookingQuantity(int bookingQuantity) {
        this.bookingQuantity = bookingQuantity;
    }

    

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getVegetableName() {
        return VegetableName;
    }

    public void setVegetableName(String VegetableName) {
        this.VegetableName = VegetableName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   

    public int getVegetableQuantity() {
        return vegetableQuantity;
    }

    public void setVegetableQuantity(int vegetableQuantity) {
        this.vegetableQuantity = vegetableQuantity;
    }
}
