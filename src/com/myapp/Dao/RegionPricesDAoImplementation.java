/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.Dao;


import com.myapp.DaoIN.RegionPricesInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.myapp.javaclasses.RegionPricesBean;
import com.util.DBUtil;

/**
 *
 * @author trainee
 */
public class RegionPricesDAoImplementation implements RegionPricesInterface {

    

    public List regionPrices(String s) {
        //throw new UnsupportedOperationException("Not supported yet.");
            List ls = new ArrayList();
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement pst = connection.prepareStatement("select VegetableDetails.VegetableName,PriceDetails.GovernmentPrice,PriceDetails.FarmerPrice,PriceDetails.WholeSellerPrice,PriceDetails.RetailerPrice from PriceDetails INNER JOIN VegetableDetails ON PriceDetails.VegetableId=VegetableDetails.VegetableId where RegionId=?");
            pst.setString(1, s);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){

                RegionPricesBean rpb = new RegionPricesBean();

                
                rpb.setVegetableName(rs.getString(1));
                rpb.setGovernmentPrice(rs.getInt(2));
                rpb.setFarmerPrice(rs.getInt(3));
                rpb.setWholeSellerPrice(rs.getInt(4));
                rpb.setRetailerPrice(rs.getInt(5));

                ls.add(rpb);
            }

        }catch(Exception e){
            e.printStackTrace();

        }
        return ls;


    }





}
