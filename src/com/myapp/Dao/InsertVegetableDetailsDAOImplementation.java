/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.myapp.DaoIN.InsertVegetableDetailsInterface;
import com.myapp.javaclasses.InsertVegetableDetailsBean;
import com.util.DBUtil;

/**
 *
 * @author trainee
 */
public class InsertVegetableDetailsDAOImplementation implements InsertVegetableDetailsInterface {

    public int insertVegetables(InsertVegetableDetailsBean ivb) {
        //throw new UnsupportedOperationException("Not supported yet.");
        int i =0;

        try{

             Connection connection = DBUtil.getConnection();
            System.out.println("connection" + connection);

            PreparedStatement pst1 = connection.prepareStatement("select VegetableName from VegetableDetails where VegetableName=?");
            pst1.setString(1, ivb.getVegetableName().toLowerCase());
            ResultSet rs = pst1.executeQuery();
            if(rs.next()){

                return i;

            }else{

            PreparedStatement pst = connection.prepareStatement("insert into VegetableDetails(VegetableId,VegetableName) values(?,?)");

            pst.setInt(1, 0);
            pst.setString(2, ivb.getVegetableName().toLowerCase());

            i = pst.executeUpdate();

            }

        }catch(Exception e){

            e.printStackTrace();
        }

        return i;
    }
    


}
