/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.elridge.sudoku.view;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author varun
 */

public class mysqlconn {
   
    Connection conn=null;
        public static Connection connectbd()
        {
            String url="jdbc:mysql://localhost:5220/game?zeroDateTimeBehavior=convertToNull";
        String uname="root";
        String pass=null;
            try{
        Class.forName("com.mysql.jdbc.Driver");
              Connection conn = DriverManager.getConnection(url,uname,pass);
               JOptionPane.showMessageDialog(null,"connected to database successfully");
               return conn;
            }
        catch(Exception e)
        {
            JOptionPane.showInternalMessageDialog(null,e);
        }
        return null;
        }
}