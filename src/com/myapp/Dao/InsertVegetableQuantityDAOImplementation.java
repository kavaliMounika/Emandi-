/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.Dao;


import com.myapp.DaoIN.InsertVegetableQuantityInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.myapp.javaclasses.InsertVegetableQuantityBean;
import com.util.DBUtil;

/**
 *
 * @author trainee
 */
public class InsertVegetableQuantityDAOImplementation implements InsertVegetableQuantityInterface {

    public int insertVegetables(InsertVegetableQuantityBean ivqb) {
        //throw new UnsupportedOperationException("Not supported yet.");

         int i =0;

        try{



             Connection connection = DBUtil.getConnection();
            System.out.println("connection" + connection);
             PreparedStatement pst1 = connection.prepareStatement("select UserId,VegetableId,VegetableQuantity,AvailableQuantity from VegetableQuantity where VegetableId=? and UserId=?");

             pst1.setInt(1, ivqb.getVegetableId());
             pst1.setInt(2, ivqb.getUserId());



             ResultSet rs = pst1.executeQuery();
             

             if(rs.next()){
               //  System.out.println("*****************************%%%%%%%%%%%"+rs.getInt(4));
                   
                 PreparedStatement pst2 = connection.prepareStatement("Update VegetableQuantity set AvailableQuantity=?, VegetableQuantity=? where UserId=? and VegetableId=?");
                 pst2.setInt(1, rs.getInt(4)+ivqb.getVegetableQuantity());
                 pst2.setInt(2, rs.getInt(3)+ivqb.getVegetableQuantity());
                 pst2.setInt(3, ivqb.getUserId());
                 pst2.setInt(4, ivqb.getVegetableId());

                i = pst2.executeUpdate();

                 return i;

             }else{

            PreparedStatement pst = connection.prepareStatement("insert into VegetableQuantity(UserId,VegetableId,VegetableQuantity,AvailableQuantity,VegetableQuantityId) values(?,?,?,?,?)");

            pst.setInt(1, ivqb.getUserId());
            pst.setInt(2, ivqb.getVegetableId());
            pst.setInt(3, ivqb.getVegetableQuantity());
            pst.setInt(4, ivqb.getVegetableQuantity());
            pst.setInt(5, 0);

            i = pst.executeUpdate();

            }

        }catch(Exception e){

            e.printStackTrace();
        }

        return i;
    }



}
