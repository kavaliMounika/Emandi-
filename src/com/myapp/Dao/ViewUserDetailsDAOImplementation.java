/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.Dao;


import com.myapp.DaoIN.ViewUserDetailsInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.myapp.javaclasses.ViewUserDetailsBean;
import com.util.DBUtil;

/**
 *
 * @author trainee
 */
public class ViewUserDetailsDAOImplementation implements ViewUserDetailsInterface {

    public List Users(ViewUserDetailsBean vudb) {
        // throw new UnsupportedOperationException("Not supported yet.");

        List ls = new ArrayList();
        try {

            Connection connection = DBUtil.getConnection();

            PreparedStatement pst = connection.prepareStatement("Select Name,UserName,Address,PhoneNumber from UserDetails1 where RoleId=?");

            pst.setInt(1, vudb.getRoleId());
            System.out.println("@@@@@@@@@@@@@" + 5);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                ViewUserDetailsBean vudb1 = new ViewUserDetailsBean();

                vudb1.setName(rs.getString(1));
                vudb1.setUserName(rs.getString(2));
                vudb1.setAddress(rs.getString(3));
                vudb1.setPhoneNumber(rs.getInt(4));
                System.out.println("@@@@@@@@@@@" + 123232);

                ls.add(vudb1);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return ls;

    }

}
