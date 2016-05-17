/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.Dao;


import com.myapp.DaoIN.InsertPriceDetailsInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.myapp.javaclasses.InsertPriceBean;
import com.util.DBUtil;

/**
 *
 * @author trainee
 */
public class InsertPriceDAOImplementation implements InsertPriceDetailsInterface {

    public int Prices(InsertPriceBean ipb) {
        //throw new UnsupportedOperationException("Not supported yet.");
        int i=0;
        try{

             Connection connection = DBUtil.getConnection();
            System.out.println("connection" + connection);
           PreparedStatement pst = connection.prepareStatement("insert into PriceDetails(PriceId,VegetableId,GovernmentPrice,FarmerPrice,WholeSellerPrice,RetailerPrice) values(?,?,?,?,?,?)");
           pst.setInt(1, 0);
           pst.setInt(2, ipb.getVegetableId());
           pst.setFloat(3, ipb.getGovernmentPrice());
           pst.setFloat(4, ipb.getFarmerPrice());
           pst.setFloat(5, ipb.getWholeSellerPrice());
           pst.setFloat(6, ipb.getRetailerPrice());

          i = pst.executeUpdate();

        }catch(Exception e){
        e.printStackTrace();

        }
        return i;
    }



}
