/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package  com.myapp.Dao;


import  com.myapp.DaoIN.ViewVegetable1Interface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import  com.myapp.javaclasses.ViewVegetable1Bean;
import com.util.DBUtil;

/**
 *
 * @author trainee
 */
public class ViewVegetable1DAOImplementation implements  ViewVegetable1Interface {

    public List viewVegetable1() {
        //throw new UnsupportedOperationException("Not supported yet.");

           List ls = new ArrayList();
        try{
              Connection connection = DBUtil.getConnection();
            System.out.println("connection" + connection);

            PreparedStatement pst = connection.prepareStatement("Select VegetableId,VegetableName from  VegetableDetails");
           
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                ViewVegetable1Bean vvb = new ViewVegetable1Bean();

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
