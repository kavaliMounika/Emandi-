/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;


import java.sql.Connection;
import java.sql.DriverManager;

import java.util.Properties;


public  class DBUtil {


    

    private static Properties prop = new Properties();
    private static String driverClassName;
    private static String url;
    private static String username;
    private static String password;
    private static Connection connection;

    static {
        try {
            
            prop.load(DBUtil.class.getResourceAsStream("databaseproperties.properties"));
            driverClassName = prop.getProperty("driverClassName");
            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");
            System.out.println(driverClassName);
            System.out.println(url);
            System.out.println(username);
            System.out.println(password);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static Connection getConnection() {
        try {
            System.out.println("1" + driverClassName);
            Class.forName(driverClassName);
            System.out.println("2");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("3");
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }

    }
    
