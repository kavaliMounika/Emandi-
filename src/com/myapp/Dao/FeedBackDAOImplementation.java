/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.Dao;


import com.myapp.DaoIN.FeedBackInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.myapp.javaclasses.FeedBackBean;
import com.util.DBUtil;

/**
 *
 * @author trainee
 */
public class FeedBackDAOImplementation implements FeedBackInterface {

    public int feedBack(FeedBackBean fbb) {
        //throw new UnsupportedOperationException("Not supported yet.");
        int i =0;
        try{

             Connection connection = DBUtil.getConnection();
            System.out.println("connection" + connection);

            PreparedStatement pst = connection.prepareStatement("insert into FeedBack(UserId,Feedback,FeedbackId,TypeId) values(?,?,?,?)");
            pst.setString(1, fbb.getUserId());
            pst.setString(2, fbb.getFeedBack());
            pst.setInt(3, 0);
            pst.setInt(4, fbb.getTypeId());

            i = pst.executeUpdate();
        

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return i;
    }

   



}
