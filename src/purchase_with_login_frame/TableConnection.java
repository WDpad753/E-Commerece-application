/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package purchase_with_login_frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */

public class TableConnection 
{
    public Connection conn;
    public Statement stmt;
    public ResultSet rst;
    
    public TableConnection()
    {
        SystemConnection();
    }
    
    public void SystemConnection()
    {
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/E-Commerce Application;create=true");
            Statement stmt= (Statement) conn.createStatement();
            JOptionPane.showMessageDialog(null, "Connection Successful!");
        }catch(Exception ext)
        {
            JOptionPane.showMessageDialog(null, "Connection not Successful!");
        }
    }
}