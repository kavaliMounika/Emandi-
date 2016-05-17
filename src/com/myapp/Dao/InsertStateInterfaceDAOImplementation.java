/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.Dao;


import com.myapp.DaoIN.InsertStateInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.myapp.javaclasses.InsertStateBean;
import com.util.DBUtil;

/**
 *
 * @author trainee
 */
public class InsertStateInterfaceDAOImplementation implements InsertStateInterface {

    public int insertState(InsertStateBean isb) {
        //throw new UnsupportedOperationException("Not supported yet.");
        int i = 0;

        try {


            Connection connection = DBUtil.getConnection();
            PreparedStatement pst1 = connection.prepareStatement("select StateName from State where StateName=?");
            pst1.setString(1, isb.getStateName().toLowerCase());

            ResultSet rs = pst1.executeQuery();
            if (rs.next()) {
                return i;
            } else {
                PreparedStatement pst = connection.prepareStatement("insert into State(StateId,StateName) values(?,?)");

                pst.setInt(1, 0);
                pst.setString(2, isb.getStateName().toLowerCase());

                i = pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return i;
    }
}
