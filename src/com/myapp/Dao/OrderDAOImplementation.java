/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package  com.myapp.Dao;


import com.myapp.DaoIN.OrderInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.myapp.javaclasses.OrderBean;
import com.util.DBUtil;

/**
 *
 * @author trainee
 */
public class OrderDAOImplementation implements OrderInterface {

    public int order(String i) {
        //throw new UnsupportedOperationException("Not supported yet.");
        int j = 0;
       // int vq = 0;

        try {
            Connection connection = DBUtil.getConnection();
            System.out.println("connection" + connection);

            PreparedStatement pst = connection.prepareStatement("select Booking.UserId,Booking.VegetableId,Booking.BookingQuantity,"
                    + "Booking.BookingTo,VegetableQuantity.VegetableQuantity,VegetableQuantity.AvailableQuantity "
                    + "from Booking INNER JOIN VegetableQuantity ON Booking.VegetableId=VegetableQuantity.VegetableId"
                    + " where BookingId=?");
            pst.setString(1, i);

            ResultSet rs = pst.executeQuery();


            if (rs.next()) {
                OrderBean ob = new OrderBean();
                ob.setUserId(rs.getInt(1));
                ob.setVegetableId(rs.getInt(2));
                ob.setBookingQuantity(rs.getInt(3));
                ob.setVegetableQuantity(rs.getInt(5));
                ob.setBookingTo(rs.getInt(4));
               // ob.setAvailableQuantity(rs.getInt(6));
                System.out.println("()()()()()()()()()()()()()()()()" + ob.getUserId());
                System.out.println("()()()()()()()()()()()()()()()()" + ob.getBookingTo());
                System.out.println("()()()()()()()()()()()()()()()()" + ob.getVegetableId());
                System.out.println("()()()()()()()()()()()()()()()()" + ob.getBookingQuantity());
                System.out.println("()()()()()()()()()()()()()()()()" + ob.getVegetableQuantity());
                System.out.println("()()()()()()()()()()()()()()()()" + ob.getAvailableQuantity());




                PreparedStatement pst8 = connection.prepareStatement("select UserId,VegetableId,AvailableQuantity from VegetableQuantity where UserId=? and VegetableId=?");
                pst8.setInt(1, ob.getBookingTo());
                pst8.setInt(2, ob.getVegetableId());
                ResultSet rs2 = pst8.executeQuery();
                if (rs2.next()) {
                    ob.setAvailableQuantity(rs2.getInt(3));
                    
                }
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&" + ob.getAvailableQuantity());
                    if (ob.getAvailableQuantity() >= ob.getBookingQuantity()) {
                        PreparedStatement pst1 = connection.prepareStatement("update VegetableQuantity set AvailableQuantity =? where VegetableId = ? and UserId = ? ");

                        pst1.setInt(1, ob.getAvailableQuantity() - ob.getBookingQuantity());
                        pst1.setInt(2, ob.getVegetableId());
                        pst1.setInt(3, ob.getBookingTo());
                        j = pst1.executeUpdate();
                    
                    if (j != 0) {

                        PreparedStatement pst3 = connection.prepareStatement("insert into Status(StatusId,Status,Date,UserId,BookedTo,VegetableId,BookingQuantity) values(?,?,CURDATE(),?,?,?,?) ");

                        pst3.setInt(1, 0);
                        pst3.setString(2, "accepted");
                        pst3.setInt(3, ob.getUserId());
                        pst3.setInt(4, ob.getBookingTo());
                        pst3.setInt(5, ob.getVegetableId());
                        pst3.setInt(6, ob.getBookingQuantity());

                        j = pst3.executeUpdate();

                        if (j != 0) {

                            PreparedStatement pst6 = connection.prepareStatement("select UserId,VegetableId,AvailableQuantity,VegetableQuantity from VegetableQuantity where UserId=? and VegetableId=?");
                            pst6.setInt(1, ob.getUserId());
                            pst6.setInt(2, ob.getVegetableId());

                            ResultSet rs1 = pst6.executeQuery();

                            if (rs1.next()) {
                                ob.setAvailableQuantity(rs1.getInt(3));
                                ob.setVegetableQuantity(rs.getInt(4));
                                System.out.println("@@@@@@@@@@@@@@@@##########" + ob.getAvailableQuantity());
                                PreparedStatement pst7 = connection.prepareStatement("update VegetableQuantity Set AvailableQuantity=? ,VegetableQuantity=? where UserId=? and VegetableId=?");
                                pst7.setInt(1, ob.getAvailableQuantity() + ob.getBookingQuantity());
                                pst7.setInt(2, ob.getVegetableQuantity() + ob.getBookingQuantity());
                                pst7.setInt(3, ob.getUserId());
                                pst7.setInt(4, ob.getVegetableId());

                                j = pst7.executeUpdate();

                            } else {
                                PreparedStatement pst5 = connection.prepareStatement("insert into VegetableQuantity(VegetableQuantityId,UserId,VegetableId,VegetableQuantity,AvailableQuantity) values(?,?,?,?,?)");
                                pst5.setInt(1, 0);
                                pst5.setInt(2, ob.getUserId());
                                pst5.setInt(3, ob.getVegetableId());
                                pst5.setInt(4, ob.getBookingQuantity());
                                pst5.setInt(5, ob.getBookingQuantity());

                                j = pst5.executeUpdate();
//
                            }



                            if (j != 0) {

                                PreparedStatement pst2 = connection.prepareStatement("delete from Booking Where BookingId=?");
                                pst2.setString(1, i);
                                pst2.executeUpdate();


                            }

                        }

                    }
                }else{
                    return j=5;

                }
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return j;
    }
}
