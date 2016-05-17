/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.Dao;


import com.myapp.DaoIN.AddComputerProfessionInterface;
import com.myapp.javaclasses.AddComputerProfessionBean;
import com.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author trainee
 */
public class AddComputerProfessionDAOImplementation implements AddComputerProfessionInterface {

    public int insert(AddComputerProfessionBean acpb) {
       // throw new UnsupportedOperationException("Not supported yet.");


          int i = 0;
        try {
            // UserDetailsBean udb = new UserDetailsBean();
            Connection connection = DBUtil.getConnection();
            System.out.println("connection" + connection);



             PreparedStatement pst1 = connection.prepareStatement("select UserName from UserDetails where UserName=?");
            pst1.setString(1, acpb.getUserName().toLowerCase());
            ResultSet rs = pst1.executeQuery();
            if(rs.next()){
                return i;
            }else{
            PreparedStatement pst = connection.prepareStatement("insert into UserDetails(UserId,RoleId,UserName,Password,Address,PhoneNumber,Name)"
                    + " values(?,?,?,?,?,?,?)");
            pst.setInt(1, 0);
            pst.setInt(2, 6);
            pst.setString(3, acpb.getUserName().toLowerCase());
            pst.setString(4, acpb.getPassword());
            pst.setString(5, acpb.getAddress());
            pst.setLong(6, acpb.getPhoneNumber());
            pst.setString(7, acpb.getName());
            i = pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return i;
    }
    }





