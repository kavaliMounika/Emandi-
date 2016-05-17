/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package  com.myapp.Dao;


import  com.myapp.DaoIN.ViewVegetablesInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import  com.myapp.javaclasses.ViewVegetablesBean;
import com.util.DBUtil;

/**
 *
 * @author trainee
 */
public class ViewVegetableDAOImplementation implements ViewVegetablesInterface {

    public List viewVegetables(String s) {
        //throw new UnsupportedOperationException("Not supported yet.");

        List ls = new ArrayList();
        try{
              Connection connection = DBUtil.getConnection();
            System.out.println("connection" + connection);

            PreparedStatement pst = connection.prepareStatement("Select VegetableQuantity.VegetableId,VegetableDetails.VegetableName from VegetableQuantity INNER JOIN VegetableDetails ON VegetableQuantity.VegetableId=VegetableDetails.VegetableId where UserId=?");
            pst.setString(1, s);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                ViewVegetablesBean vvb = new ViewVegetablesBean();

                vvb.setVegetableId(rs.getInt(1));
                vvb.setVegetableName(rs.getString(2));

                System.out.println("((((((((((((((((())))))))))))))))"+ vvb.getVegetableName());

                ls.add(vvb);

            }


        }catch(Exception e){
        e.printStackTrace();

        }
        return ls;
    }




}
