/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.Dao;


import  com.myapp.DaoIN.OrderDeclineActionInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.myapp.javaclasses.OrderBean;
import com.util.DBUtil;

/**
 *
 * @author trainee
 */
public class OrderDeclineActionDAOImplementation implements OrderDeclineActionInterface {

    public int orderDecline(String s) {
       // throw new UnsupportedOperationException("Not supported yet.");

         int j =0;
        int vq=0;

        try{
            Connection connection = DBUtil.getConnection();
            System.out.println("connection" + connection);

            PreparedStatement pst = connection.prepareStatement("select Booking.UserId,Booking.VegetableId,Booking.BookingQuantity,Booking.BookingTo,VegetableQuantity.VegetableQuantity,VegetableQuantity.AvailableQuantity from Booking INNER JOIN VegetableQuantity ON Booking.VegetableId=VegetableQuantity.VegetableId where BookingId=?");
            pst.setString(1, s);

            ResultSet rs = pst.executeQuery();


            if(rs.next()){
                OrderBean ob = new OrderBean();
                ob.setUserId(rs.getInt(1));
                ob.setVegetableId(rs.getInt(2));
                ob.setBookingQuantity(rs.getInt(3));
                ob.setVegetableQuantity(rs.getInt(5));
                ob.setBookingTo(rs.getInt(4));
                ob.setAvailableQuantity(rs.getInt(6));
                 System.out.println("()()()()()()()()()()()()()()()()"+ob.getUserId());
                 System.out.println("()()()()()()()()()()()()()()()()"+ob.getVegetableId());
                 System.out.println("()()()()()()()()()()()()()()()()"+ob.getBookingQuantity());
                 System.out.println("()()()()()()()()()()()()()()()()"+ob.getVegetableQuantity());
                 System.out.println("()()()()()()()()()()()()()()()()"+ob.getAvailableQuantity());

                //if(ob.getVegetableQuantity()<ob.getBookingQuantity()){
                if(ob.getAvailableQuantity()==0){
                vq = ob.getVegetableQuantity()-ob.getBookingQuantity();
                }else{
                 vq = ob.getAvailableQuantity()-ob.getBookingQuantity();
                }
                              

                        PreparedStatement pst3 =connection.prepareStatement("insert into Status(StatusId,Status,Date,UserId,BookedTo,VegetableId,BookingQuantity) values(?,?,CURDATE(),?,?,?,?) ");

                        pst3.setInt(1, 0);
                        pst3.setString(2, "Declined");
                        pst3.setInt(3, ob.getUserId());
                        pst3.setInt(4, ob.getBookingTo());
                        pst3.setInt(5, ob.getVegetableId());
                        pst3.setInt(6, ob.getBookingQuantity());

                       j = pst3.executeUpdate();


               if(j!=0){

                    PreparedStatement pst2 =connection.prepareStatement("delete from Booking Where BookingId=?");
                    pst2.setString(1, s);
                     pst2.executeUpdate();


                    }
            

            }

    }catch(Exception e){
        e.printStackTrace();
    }
                return j;
    }

}
