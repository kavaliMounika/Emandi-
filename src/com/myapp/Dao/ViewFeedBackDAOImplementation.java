/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package  com.myapp.Dao;


import com.myapp.DaoIN.ViewFeedBackInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import  com.myapp.javaclasses.ViewFeedBackBean;
import com.util.DBUtil;

/**
 *
 * @author trainee
 */
public class ViewFeedBackDAOImplementation implements ViewFeedBackInterface {

    public List feedBack(ViewFeedBackBean vfb) {
        //throw new UnsupportedOperationException("Not supported yet.");
        
        List ls = new ArrayList();
         try{

             Connection connection = DBUtil.getConnection();

           PreparedStatement pst = connection.prepareStatement("Select UserDetails1.Name,FeedBack.Feedback,FeedBackType.TypeName from FeedBack INNER JOIN UserDetails1 ON UserDetails1.UserId = FeedBack.UserId INNER JOIN FeedBackType ON FeedBackType.TypeId= FeedBack.TypeId where FeedBack.TypeId=?");

           pst.setInt(1, vfb.getTypeId());
           ResultSet rs = pst.executeQuery();

           while(rs.next()){

                ViewFeedBackBean vfb1 = new ViewFeedBackBean();
                vfb1.setName(rs.getString(1));
                vfb1.setFeedBack(rs.getString(2));
                vfb1.setTypeName(rs.getString(3));
                
                System.out.println("+++++++++++++++++++"+vfb.getName());
                System.out.println("++++++++++++++"+vfb.getFeedBack());

                ls.add(vfb1);
           }


        }catch(Exception e){
        e.printStackTrace();

        }
         return ls;

    }



}
