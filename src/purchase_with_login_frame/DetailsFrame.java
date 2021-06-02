/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package purchase_with_login_frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static purchase_with_login_frame.OrdersFrame.Quan;
import static purchase_with_login_frame.WelcomePage.Cust_ID;

/**
 *
 * @author Admin
 */
public class DetailsFrame extends javax.swing.JFrame {
    public Connection conn = null;
    public Connection conn1 = null;
    public Statement stmt;
    public ResultSet rst;
    public int Quantity;
    
    /**
     * Creates new form DetailsFrame
     */
    
    public DetailsFrame() {
        initComponents();
//        show_Details();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Please enter required Quantity");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Quantity:");

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        PurchaseFrame page = new PurchaseFrame();
        page.setVisible(true);
        page.getContentPane();
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        //int Quan;
        Quan = Integer.parseInt(jTextField1.getText());
        if(Quan > Quantity)
        {
            System.out.println(Quan);
            System.out.println(Quantity);
            JOptionPane.showMessageDialog(null, "Invalid input");
        }
        else
        {
            System.out.println(Quan);
            System.out.println(Quantity);
            JOptionPane.showMessageDialog(null, "Value within the available stock");
        }
        
        OrdersFrame page = new OrdersFrame();
        Order pageclass = new Order();
        pageclass.setQuan(Quan);
        page.setInt(Quan);
        dispose();
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //Order newOrder = new Order();
        //newOrder.setInt(Quan);
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DetailsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetailsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetailsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetailsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetailsFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    public int setran(int randnum) {
    System.out.println(randnum);
    return randnum;
    }
    
    public ArrayList<Order> getQuanList() throws SQLException 
    {
        ArrayList<Order> orderList = new ArrayList<Order>();

        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            System.out.println("Going to connect to database");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/E-Commerce Application;create=true");
            conn1 = DriverManager.getConnection("jdbc:derby://localhost:1527/E-Commerce Application;create=true");
            System.out.println("Connection Successfull");
            Statement stmt = conn.createStatement();
            ResultSet rst = stmt.executeQuery("SELECT * FROM APP.ORDERDETAILS");
            Order Order;
            while(rst.next())
            {
                Order = new Order(rst.getInt("ORDER_ID"), rst.getInt("ORDER_NUMBER"), rst.getInt("CUSTOMER_ID"), rst.getInt("PRODUCT_ID"), rst.getString("PRODUCTNAME"), rst.getInt("QUANTITY"), rst.getInt("PRICE"));
                orderList.add(Order);
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Connection to database is unsuccessful");
        }
        return orderList;
    }
    
    public void show_Details()
    {
        try {
            ArrayList<Order> list = getQuanList();
            Object[] row = new Object[7];
            for(int i =0; i<list.size(); i++)
            {
                row[0] = list.get(i).getOrder_ID();
                row[1] = list.get(i).getOrder_Number();
                row[2] = list.get(i).getCustomer_ID();
                row[3] = list.get(i).getProduct_ID();
                row[4] = list.get(i).getProductName();
                row[5] = list.get(i).getQuantity();
                row[6] = list.get(i).getPrice();
            }
            System.out.println(Quantity);
            Quantity = (int) row[5];
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Table could not be found");
        }
    }
}
