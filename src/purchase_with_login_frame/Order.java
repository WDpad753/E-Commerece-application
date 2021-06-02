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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static purchase_with_login_frame.OrdersFrame.Quan;

/**
 *
 * @author Admin
 */

class Order 
{
    private int Order_ID;
    private int Order_Number;
    private int Customer_ID;
    private int Product_ID;
    private String ProductName;
    private int Quantity;
    int quan = setInt(Quan);
    int Quant = setQuan(Quan);
    private int Price;
    
    public Connection conn = null;
    public Statement stmt;
    public ResultSet rst;
    
    public Order(int Order_ID, int Order_Number, int Customer_ID, int Product_ID, String ProductName, int Quantity, int Price)
    {
        this.Order_ID = Order_ID;
        this.Order_Number = Order_Number;
        this.Customer_ID = Customer_ID;
        this.Product_ID = Product_ID;
        this.ProductName = ProductName;
        this.Quantity = Quantity;
        this.Price = Price;
    }

    Order(){}
    
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
            PreparedStatement stmt2 = conn.prepareStatement("SELECT ORDER_NUMBER FROM APP.ORDERDETAILS WHERE ORDER_NUMBER =" + Order_Number +" AND Product_ID =" + Product_ID);
            System.out.println("Order_Number"+ Order_Number + "Product_ID=" + Product_ID);
            PreparedStatement stmt1 = conn.prepareStatement("UPDATE APP.ORDERDETAILS SET QUANTITY = ? WHERE ORDER_NUMBER ="+ Order_Number);
            ResultSet rst = stmt2.executeQuery();
            while(rst.next())
            {
                stmt1.setInt(1,Quant);
                stmt1.executeUpdate();
            }
        }catch (ClassNotFoundException ex) {
            System.err.println("Got an exception!"); 
            System.err.println(ex.getMessage());
        }
        finally{
            try {
                conn.close();
            }catch (SQLException ex) 
                {
                    Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
                return Quan;
    }
    
    public int getPrice()
    {
        return Price;
    }

    int setInt(int Quan) {
        return Quan;
    }

    public int setQuan(int Quan) {
       System.out.println("Quantity ="+ Quan);
       return Quan;
    }
}

