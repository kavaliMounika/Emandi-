/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package  com.myapp.Dao;


import  com.myapp.DaoIN.ViewAvailableQuantityInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import  com.myapp.javaclasses.DistictBean;
import  com.myapp.javaclasses.ViewAvailableQuantityBean;
import com.util.DBUtil;

/**
 *
 * @author trainee
 */
public class ViewAvailableQuantityDAOImplementation implements  ViewAvailableQuantityInterface {

    public List available(ViewAvailableQuantityBean vaqb) {
        //throw new UnsupportedOperationException("Not supported yet.");
            List ls = new ArrayList();
         try{

            Connection connection = DBUtil.getConnection();

            PreparedStatement pst = connection.prepareStatement("select AvailableQuantity from VegetableQuantity where UserId=? and VegetableId=?");


          pst.setString(1, vaqb.getUserId());
          pst.setInt(2, vaqb.getVegetableId());

            ResultSet rs = pst.executeQuery();

            while(rs.next()){

                ViewAvailableQuantityBean vaqbb = new ViewAvailableQuantityBean();

                vaqbb.setAvailableQuantity(rs.getInt(1));

                ls.add(vaqbb);

            }


        }catch(Exception e){
            e.printStackTrace();
        }
        return ls;
    }




}
