/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.Dao;

import com.myapp.DaoIN.BookingRequestDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.myapp.javaclasses.BookingRequestBean;
import com.util.DBUtil;

/**
 *
 * @author trainee
 */
public class BookingRequestDao implements BookingRequestDaoImpl {

    public List bookingRequest(BookingRequestBean brb) {
        // throw new UnsupportedOperationException("Not supported yet.");


        List ls = new ArrayList();

        try {
            Connection connection = DBUtil.getConnection();
            System.out.println("connection" + connection);

            PreparedStatement pst1 = connection.prepareStatement("select UserDetails1.Name,VegetableDetails.VegetableName,Status.BookingQuantity,Status.Date,Status.Status from Status INNER JOIN UserDetails1 ON Status.BookedTo= UserDetails1.UserId INNER JOIN VegetableDetails ON Status.VegetableId=VegetableDetails.VegetableId where Status.UserId=?");
            pst1.setString(1, brb.getUserId());
            ResultSet rs1 = pst1.executeQuery();

            while (rs1.next()) {

                BookingRequestBean brb2 = new BookingRequestBean();
                brb2.setName(rs1.getString(1));
                brb2.setVegetableName(rs1.getString(2));
                brb2.setVegetableQuantity(rs1.getInt(3));
                brb2.setDate(rs1.getString(4));
                brb2.setStatus(rs1.getString(5));

                ls.add(brb2);


            }


            PreparedStatement pst = connection.prepareStatement("select UserDetails.name,VegetableDetails.VegetableName,Booking.BookingQuantity from Booking INNER JOIN UserDetails ON Booking.BookingTo = UserDetails.UserId INNER JOIN VegetableDetails ON Booking.VegetableId=VegetableDetails.VegetableId where Booking.UserId=?");
            pst.setString(1, brb.getUserId());
            ResultSet rs = pst.executeQuery();


            while (rs.next()) {
                BookingRequestBean brb1 = new BookingRequestBean();

                brb1.setName(rs.getString(1));
                brb1.setVegetableName(rs.getString(2));
                brb1.setVegetableQuantity(rs.getInt(3));

                ls.add(brb1);
            }




        } catch (Exception e) {

            e.printStackTrace();
        }

        return ls;


    }
}
