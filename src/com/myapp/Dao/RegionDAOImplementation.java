/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.Dao;



import com.myapp.DaoIN.RegionInterface;
import com.myapp.javaclasses.RegionBean;
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
public class RegionDAOImplementation implements RegionInterface {

    public List region(String s) {
        //throw new UnsupportedOperationException("Not supported yet.");
        List ls = new ArrayList();
        try{

            Connection connection = DBUtil.getConnection();
            PreparedStatement pst = connection.prepareStatement("select RegionId,RegionName from Region where DistictId =?");

            pst.setString(1, s);
            System.out.println("*******************************************************"+s);

            ResultSet rs = pst.executeQuery();


            while(rs.next()){
            RegionBean rb = new RegionBean();

            rb.setRegionId(rs.getInt(1));
            rb.setRegionName(rs.getString(2));

            ls.add(rb);
            }

        }catch(Exception e){
                  e.printStackTrace();
        }
        return ls;
    }


}
