/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.Dao;

import com.myapp.DaoIN.BookingDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.myapp.javaclasses.BookingBean;
import com.util.DBUtil;

/**
 *
 * @author trainee
 */
public class BookingDao implements BookingDaoImpl {

     public int booking(BookingBean bb) {
        //throw new UnsupportedOperationException("Not supported yet.");

        int i = 0;
        try {
            // UserDetailsBean udb = new UserDetailsBean();
            Connection connection = DBUtil.getConnection();
            System.out.println("connection" + connection);

            PreparedStatement pst = connection.prepareStatement("insert into Booking(BookingId,UserId,RoleId,BookingQuantity,VegetableId,BookingDate,BookingTo)"
                    + " values(?,?,?,?,?,?,?)");
            pst.setInt(1, 0);
            pst.setInt(2, bb.getUserId());
            pst.setInt(3, bb.getRoleId());
            pst.setInt(4, bb.getBookingQuantity());
            pst.setInt(5, bb.getVegetableId());
            pst.setDate(6, bb.getBookingDate());
            pst.setInt(7, bb.getBookingTo());
            i = pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return i;
    }

}
