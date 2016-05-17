/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.Dao;

import com.myapp.DaoIN.UserDetailsDaoImpl;
import com.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.myapp.javaclasses.UserDetailsBean;

/**
 *
 * @author trainee
 */
public class UserDetailsDao implements UserDetailsDaoImpl {



    public int setValues(UserDetailsBean udb) {
        // throw new UnsupportedOperationException("Not supported yet.");
        int i = 0;
        try {
            // UserDetailsBean udb = new UserDetailsBean();

            Connection connection = DBUtil.getConnection();
            System.out.println("connection" + connection);
            //System.out.println("*******************phone"+udb.getPhoneNumber());
            PreparedStatement pst1 = connection.prepareStatement("select UserName from UserDetails1 where UserName=?");
            pst1.setString(1, udb.getUserName().toLowerCase());
            ResultSet rs = pst1.executeQuery();
            if(rs.next()){
                return i;

            }else{
            PreparedStatement pst = connection.prepareStatement("insert into UserDetails1(userId, RoleId,Name, UserName, Password, Address, PhoneNumber) values(?,?,?,?,?,?,?)");

            pst.setInt(1, 0);
            pst.setInt(2, udb.getRoleId());
            pst.setString(3, udb.getName());
            pst.setString(4, udb.getUserName().toLowerCase());
            pst.setString(5, udb.getPassword());
            pst.setString(6, udb.getAddress());
            pst.setLong(7, udb.getPhoneNumber());

            i = pst.executeUpdate();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return i;

    }

}
