/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.Dao;



import com.myapp.DaoIN.VegetableDetailsInterface;
import com.myapp.javaclasses.VegetableDetailsBean;
import com.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author trainee
 */
public class VegetableDetailsDAOImplementation implements VegetableDetailsInterface {

      public List details(VegetableDetailsBean vdb) {
        //throw new UnsupportedOperationException("Not supported yet.");
        int i = 0;
        List ls = new ArrayList();
        try {

            Connection connection = DBUtil.getConnection();
            System.out.println("connection" + connection);

            PreparedStatement pst = connection.prepareStatement("select Role.RoleName, UserDetails1.Name, VegetableDetails.VegetableName, VegetableQuantity.AvailableQuantity, VegetableQuantity.VegetableQuantity from VegetableQuantity INNER JOIN VegetableDetails ON VegetableQuantity.VegetableId= VegetableDetails.VegetableId INNER JOIN UserDetails1 ON VegetableQuantity.UserId= UserDetails1.UserId INNER JOIN Role ON Role.RoleId = UserDetails1.RoleId where VegetableQuantity.VegetableId=? ");
            pst.setInt(1, vdb.getVegetableId());

            System.out.println("------------------------");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                VegetableDetailsBean vdb1 = new VegetableDetailsBean();

                vdb1.setrName(rs.getString(1));
                vdb1.setName(rs.getString(2));
                vdb1.setVegetableName(rs.getString(3));
                vdb1.setVegetableQuantity(rs.getInt(5));
                vdb1.setAvailableQuantity(rs.getInt(4));

                System.out.println("**********" + vdb.getVegetableName());

                ls.add(vdb1);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }


}
