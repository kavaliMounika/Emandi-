/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package  com.myapp.Dao;


import com.myapp.DaoIN.ViewPricesInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import  com.myapp.javaclasses.ViewPricesBean;
import com.util.DBUtil;

/**
 *
 * @author trainee
 */
public class ViewPricesDAOImplementation implements ViewPricesInterface {

     public List prices() {
        //throw new UnsupportedOperationException("Not supported yet.");
        List ls = new ArrayList();
        try {

            Connection connection = DBUtil.getConnection();
            //PreparedStatement pst = connection.prepareStatement("select PriceId,VegetableId,GovernmentPrice,FarmerPrice,WholeSellerPrice,"
              //      + "RetailerPrice from PriceDetails");
            /*PreparedStatement pst = connection.prepareStatement("SELECT PriceDetails.PriceId,VegetableDetails.VegetableName,PriceDetails.GovernmentPrice,"
                    + "PriceDetails.FarmerPrice,PriceDetails.WholeSellerPrice,PriceDetails.RetailerPrice"
                    + " from PriceDetails INNER JOIN VegetableDetails "
                    + "ON PriceDetails.VegetableId = VegetableDetails.VegetableId");
            */

            PreparedStatement pst = connection.prepareStatement("select PriceDetails.PriceId,VegetableDetails.VegetableName,"
                    + "PriceDetails.GovernmentPrice,PriceDetails.FarmerPrice,PriceDetails.WholeSellerPrice,"
                    + "PriceDetails.RetailerPrice from PriceDetails INNER JOIN VegetableDetails ON PriceDetails.VegetableId = "
                    + "VegetableDetails.VegetableId");

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ViewPricesBean vpb = new ViewPricesBean();

                vpb.setPriceId(rs.getInt(1));
                vpb.setVegetableName(rs.getString(2));
              //  vpb.setRegionName(rs.getString(3));
                vpb.setGovernmentPrice(rs.getFloat(3));
                vpb.setFarmerPrice(rs.getFloat(4));
                vpb.setWholeSellerPrice(rs.getFloat(5));
                vpb.setRetailerPrice(rs.getFloat(6));


                ls.add(vpb);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;

    }

}
