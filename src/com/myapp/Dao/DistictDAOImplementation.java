/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.Dao;


import com.myapp.DaoIN.DistictInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.myapp.javaclasses.DistictBean;
import com.util.DBUtil;

/**
 *
 * @author trainee
 */
public class DistictDAOImplementation implements DistictInterface {

      public List distict(String s) {
        //throw new UnsupportedOperationException("Not supported yet.");
        List ls = new ArrayList();
        try{

            Connection connection = DBUtil.getConnection();

            PreparedStatement pst = connection.prepareStatement("Select DisticId,DistictName from Distict where StateId=?");


          pst.setString(1, s);
            System.out.println("********************************"+s);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                DistictBean db = new DistictBean();
                db.setDistictId(rs.getInt(1));
                db.setDistictName(rs.getString(2));

                ls.add(db);
            }


        }catch(Exception e){
            e.printStackTrace();
        }
        return ls;
    }
}


