/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package purchase_with_login_frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static purchase_with_login_frame.OrdersFrame.Quan;

/**
 *
 * @author Admin
 */

class Cart 
{
    private int Order_ID;
    private int Order_Number;
    private int Customer_ID;
    private int Product_ID;
    private String ProductName;
    private int Quantity;
    int quan = setInt(Quan);
    private int Price;
    
    public Connection conn = null;
    public Statement stmt;
    public ResultSet rst;
    
    public Cart(int Order_ID, int Order_Number, int Customer_ID, int Product_ID, String ProductName, int Quantity, int Price)
    {
        this.Order_ID = Order_ID;
        this.Order_Number = Order_Number;
        this.Customer_ID = Customer_ID;
        this.Product_ID = Product_ID;
        this.ProductName = ProductName;
        this.Quantity = Quantity;
        this.Price = Price;
    }
    
    public int getOrder_ID()
    {
        return Order_ID;
    }
    
    public int getOrder_Number()
    {
        return Order_Number;
    }
    
    public int getCustomer_ID()
    {
        return Customer_ID;
    }
    
    public int getProduct_ID()
    {
        return Product_ID;
    }
    
    public String getProductName()
    {
        return ProductName;
    }
    
        public int getQuantity()
    {
        return Quantity;
    }
        
        public int getQuantity1() throws SQLException
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            System.out.println("Going to connect to database");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/E-Commerce Application;create=true");
            System.out.println("Connection Successfull");
            //PreparedStatement stmt2 = conn.prepareStatement("SELECT CUSTOMER_ID FROM APP.CUSTOMERDETAILS WHERE CUSTOMER_ID =" + customerid);
            PreparedStatement stmt1 = conn.prepareStatement("UPDATE APP.ORDERDETAILS SET QUANTITY = ? WHERE ORDER_NUMBER ="+ Order_Number);
            //ResultSet rst = stmt.executeQuery();
            while(rst.next())
            {
                stmt1.setInt(1,Quan);
                
                stmt1.executeUpdate();
            }
        }catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Connection to database is unsuccessful");
        }
        return Quan;
    }
    
    public int getPrice()
    {
        return (Price * Quan);
    }

    int setInt(int Quan) {
        return Quan;
    }
}
