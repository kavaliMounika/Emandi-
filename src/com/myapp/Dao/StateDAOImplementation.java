/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.Dao;



import com.myapp.DaoIN.StateInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.myapp.javaclasses.StateBean;
import com.util.DBUtil;

/**
 *
 * @author trainee
 */
public class StateDAOImplementation implements StateInterface {

     public List state() {
       // throw new UnsupportedOperationException("Not supported yet.");
        List ls = new ArrayList();
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement pst = connection.prepareStatement("select StateId, StateName from State");
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
            StateBean sb = new StateBean();
            sb.setStateId(rs.getInt(1));
            sb.setStateName(rs.getString(2));

            ls.add(sb);
            }
        }catch(Exception e){

        }
        return ls;

    }

}
