/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.javaclasses;

/**
 *
 * @author trainee
 */
public class OrderBean {

    private int bookingQuantity;
    private int vegetableQuantity;
    private int availableQuantity;
    private int userId;
    private int vegetableId;
    private int bookingTo;

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }


    

    public int getBookingTo() {
        return bookingTo;
    }

    public void setBookingTo(int bookingTo) {
        this.bookingTo = bookingTo;
    }

    

    public int getVegetableId() {
        return vegetableId;
    }

    public void setVegetableId(int vegetableId) {
        this.vegetableId = vegetableId;
    }

    

    public int getBookingQuantity() {
        return bookingQuantity;
    }

    public void setBookingQuantity(int bookingQuantity) {
        this.bookingQuantity = bookingQuantity;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVegetableQuantity() {
        return vegetableQuantity;
    }

    public void setVegetableQuantity(int vegetableQuantity) {
        this.vegetableQuantity = vegetableQuantity;
    }

    

}
