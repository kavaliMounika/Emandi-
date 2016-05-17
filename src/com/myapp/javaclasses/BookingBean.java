/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.javaclasses;

import java.sql.Date;

/**
 *
 * @author trainee
 */
public class BookingBean {

    private int bookingQuantity;
    private int vegetableId;
    private Date bookingDate;
    private int userId;
    private int bookingTo;
    private int roleId;
    private int availableQuantity;

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }


    

    public int getBookingTo() {
        return bookingTo;
    }

    public void setBookingTo(int bookingTo) {
        this.bookingTo = bookingTo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getBookingQuantity() {
        return bookingQuantity;
    }

    public void setBookingQuantity(int bookingQuantity) {
        this.bookingQuantity = bookingQuantity;
    }

    public int getVegetableId() {
        return vegetableId;
    }

    public void setVegetableId(int vegetableId) {
        this.vegetableId = vegetableId;
    }
}
