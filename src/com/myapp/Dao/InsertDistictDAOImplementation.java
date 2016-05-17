/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.Dao;


import com.myapp.DaoIN.InsertDistictInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.myapp.javaclasses.InsertDistictBean;
import com.util.DBUtil;

/**
 *
 * @author trainee
 */
public class InsertDistictDAOImplementation implements InsertDistictInterface {

    public int insertDistict(InsertDistictBean idb) {
        //throw new UnsupportedOperationException("Not supported yet.");

         int i=0;

        try{


         Connection connection = DBUtil.getConnection();
         PreparedStatement pst1 =connection.prepareStatement("select DistictName from Distict where DistictName=?");

            pst1.setString(1, idb.getDistictName().toLowerCase());
            ResultSet rs = pst1.executeQuery();
            if(rs.next()){
                    return i;
                    
            }else{
            PreparedStatement pst = connection.prepareStatement("insert into Distict(DisticId,DistictName,StateId) values(?,?,?)");

            pst.setInt(1, 0);
            pst.setString(2, idb.getDistictName().toLowerCase());
            pst.setInt(3, idb.getStateId());

            i= pst.executeUpdate();
            }
        }catch(Exception e){
        e.printStackTrace();

        }
        return i;
    }

    }





