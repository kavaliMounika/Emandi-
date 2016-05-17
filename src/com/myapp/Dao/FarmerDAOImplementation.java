/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.Dao;

import com.myapp.DaoIN.FarmerInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.myapp.javaclasses.FarmerBean;
import com.util.DBUtil;

/**
 *
 * @author trainee
 */
public class FarmerDAOImplementation implements FarmerInterface {

    public List farmer(FarmerBean fb) {
       // throw new UnsupportedOperationException("Not supported yet.");
        List ls = new ArrayList();
        try{
           // FarmerBean fb = new FarmerBean();
             Connection connection = DBUtil.getConnection();
            System.out.println("connection" + connection);


            PreparedStatement pst = connection.prepareStatement("select UserId,Name from UserDetails1 where RoleId =? and UserId!=?");
            pst.setInt(1, fb.getRoleId());
            pst.setInt(2, fb.getUserId());
            ResultSet rs = pst.executeQuery();

            while(rs.next()){

                FarmerBean fb1 = new FarmerBean();
                fb1.setUserId(rs.getInt(1));
                fb1.setName(rs.getString(2));
                //System.out.println("**********************"+i);

                ls.add(fb1);
            }

        }catch(Exception e){
        e.printStackTrace();

        }
        return ls;
    }



    

}
