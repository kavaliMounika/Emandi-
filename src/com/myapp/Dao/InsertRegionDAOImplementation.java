/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.Dao;


import com.myapp.DaoIN.InsertRegionInterface;
import com.myapp.javaclasses.InsertRegionBean;
import com.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author trainee
 */
public class InsertRegionDAOImplementation implements InsertRegionInterface {

    public int insertRegion(InsertRegionBean irb) {
        //throw new UnsupportedOperationException("Not supported yet.");

         int i=0;

        try{


         Connection connection = DBUtil.getConnection();

            PreparedStatement pst1 = connection.prepareStatement("select RegionName from Region where RegionName=?");
                pst1.setString(1, irb.getRegionName().toLowerCase());
                ResultSet rs = pst1.executeQuery();

                if(rs.next()){
                    
                    return i;

                }else{

            PreparedStatement pst = connection.prepareStatement("insert into Region(RegionId,RegionName,DistictId) values(?,?,?)");

            pst.setInt(1, 0);
            pst.setString(2, irb.getRegionName().toLowerCase());
            pst.setInt(3, irb.getDistictId());

            i= pst.executeUpdate();
            }
        }catch(Exception e){
        e.printStackTrace();

        }
        return i;

    }



}
