package com.myapp.Dao;



import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;

import com.myapp.DaoIN.LoginDetailsDaoImpl;
import com.myapp.javaclasses.LoginDetailsBean;
import com.util.DBUtil;

public class LoginDetailsDao implements LoginDetailsDaoImpl{

	public int loginUser(LoginDetailsBean b){
		
		int userId = 0;
		PreparedStatement pst =null;
		Connection con = null;
		try{
		 con= DBUtil.getConnection();
		pst = con.prepareStatement("select userId , roleId from UserDetails1 where userName = ? and password = ?");
		
		pst.setString(1, b.getUserName());
		pst.setString(2, b.getPassword());
		
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()){
			userId = rs.getInt("userId");
			b.setRoleId(rs.getInt(2));


            return userId;
		} 
	}catch (Exception e){
		
	}finally {
		try{
			if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            pst = null;
            con = null;

        }

	}
		return userId;
	}
	
}

