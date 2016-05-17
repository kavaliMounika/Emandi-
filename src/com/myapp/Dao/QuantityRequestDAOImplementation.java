/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package  com.myapp.Dao;


import  com.myapp.DaoIN.QuantityRequestInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import  com.myapp.javaclasses.QuantityRequestBean;
import com.util.DBUtil;

/**
 *
 * @author trainee
 */
public class QuantityRequestDAOImplementation implements QuantityRequestInterface {

    public int request(QuantityRequestBean qrb) {
       // throw new UnsupportedOperationException("Not supported yet.");

         int i =0;

        try{



             Connection connection = DBUtil.getConnection();
            System.out.println("connection" + connection);
           
            PreparedStatement pst = connection.prepareStatement("insert into QuantityRequest(VegetableId,Quantity,UserId,QuantityRequestId,Status) values(?,?,?,?,?)");

            pst.setInt(1, qrb.getVegetableId());
            pst.setInt(2, qrb.getVegetableQuantity());
            pst.setString(3, qrb.getUserId());
            pst.setInt(4, 0);
            pst.setString(5, "Pending");

            i = pst.executeUpdate();

       

        }catch(Exception e){

            e.printStackTrace();
     }

        return i;
    }
    



}
