/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.Dao;


import com.myapp.DaoIN.DeleteQuantityRequestInterface;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author trainee
 */
public class DeleteQuantityRequestDAOImplementation implements DeleteQuantityRequestInterface {

    public int delete(String id,String id1) {
        //throw new UnsupportedOperationException("Not supported yet.");


         int i=0;

        try{


         Connection connection = DBUtil.getConnection();



            PreparedStatement pst = connection.prepareStatement("update QuantityRequest set Status=? where UserId =? and VegetableId=?");
            pst.setString(1, "Accepted");
            pst.setString(2, id);
            pst.setString(3, id1);

            i= pst.executeUpdate();

        }catch(Exception e){
        e.printStackTrace();

        }
        return i;
    }



}
