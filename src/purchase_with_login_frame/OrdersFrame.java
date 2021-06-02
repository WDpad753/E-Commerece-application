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
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static purchase_with_login_frame.WelcomePage.Cust_ID;

/**
 *
 * @author Admin
 */
public class OrdersFrame extends javax.swing.JFrame {
    public Connection conn = null;
    public Connection conn1 = null;
    public Statement stmt = null;
    public Statement stmt1 = null;
    public ResultSet rst;
    public static int Quan;
    public int randnum;
    public static String prod;
    int order_ID;
    int price;
    int ranno;
    
    /**
     * Creates new form OrdersFrame
     */
    public OrdersFrame() {
        initComponents();
        show_table();
    }
    
    public ArrayList<Order> getOrderList() throws SQLException 
    {
        ArrayList<Order> orderList = new ArrayList<Order>();
        int customerid = setInt(Cust_ID);
        int Quant = setQuan(Quan);
        ranno = setran(randnum);
        
        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            System.out.println("Going to connect to database");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/E-Commerce Application;create=true");
            conn1 = DriverManager.getConnection("jdbc:derby://localhost:1527/E-Commerce Application;create=true");
            System.out.println("Connection Successfull");
            Statement stmt = conn.createStatement();
            ResultSet rst = stmt.executeQuery("SELECT * FROM APP.ORDERDETAILS WHERE CUSTOMER_ID="+customerid);
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
    
    public void show_table()
    {
        try {
            ArrayList<Order> list = getOrderList();
            DefaultTableModel model = (DefaultTableModel) jXTable1.getModel();
            Object[] row = new Object[7];
            for(int i =0; i<list.size(); i++){
            row[0] = list.get(i).getOrder_ID();
            row[1] = list.get(i).getOrder_Number();
            row[2] = list.get(i).getCustomer_ID();
            row[3] = list.get(i).getProduct_ID();
            row[4] = list.get(i).getProductName();
            row[5] = list.get(i).getQuantity();
            int Quantity = (int) row[5];
            row[6] = list.get(i).getPrice() * Quantity;
            model.addRow(row);
            getsum();
        }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Table could not be found");
        }
    }
    
    public void executeSQLQuery(String query, String message) throws SQLException
    {
        conn1 = DriverManager.getConnection("jdbc:derby://localhost:1527/E-Commerce Application;create=true");
        try
        {
            stmt1 = conn1.createStatement();
            if(stmt1.executeUpdate(query) == 1)
            {
                DefaultTableModel model = (DefaultTableModel) jXTable1.getModel();
                model.setRowCount(0);
                show_table();
                JOptionPane.showMessageDialog(null, "Data " +message+" Successfully!");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Data " +message+" is unsuccessfully!");
            }
        } catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Query can not be executed");
        }
         finally{
                try {
                    conn.close();
                    conn1.close();
                } catch (SQLException ex) 
                {
                    Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }

          public void getsum()
      {
          int sum=0;
          for(int i=0; i<jXTable1.getRowCount(); i++)
          {
              sum = sum + Integer.parseInt(jXTable1.getValueAt(i,6).toString());
          }
          jTextField3.setText(Integer.toString(sum));
      }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jXTable1 = new org.jdesktop.swingx.JXTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jXTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Order Number", "Customer ID", "Product ID", "Product Name", "Quantity", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jXTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jXTable1);

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Your Orders");

        jButton2.setText("Amend");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Order ID:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Quantity:");

        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Total:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 871, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(499, 499, 499)))))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(208, 208, 208)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(141, 141, 141)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton2)
                                        .addComponent(jButton3)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(214, 214, 214)
                                    .addComponent(jLabel2))))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(9, 9, 9)
                .addComponent(jButton1)
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        /*JFrame frame = new JFrame();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);*/
        //Window
        WelcomePage page = new WelcomePage();
        dispose();
        page.setVisible(true);
        page.getContentPane();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Quan = Integer.parseInt(jTextField2.getText());
        System.out.println(Quan);
        System.out.println("Order ID:" + order_ID);
        int count= jXTable1.getModel().getRowCount();
        String query = "UPDATE APP.ORDERDETAILS SET QUANTITY ="+jTextField2.getText()+ " WHERE ORDER_ID ="+jTextField1.getText();
        
        if(count!=0){
        try {
            executeSQLQuery(query,"Update");
            jTextField1.setText("");
            jTextField2.setText("");
//            jTextField3.setText("");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Query is not executed");
        }
        } else{
            JOptionPane.showMessageDialog(null, "Table is empty!");
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int count= jXTable1.getModel().getRowCount();
        boolean switch_while = true;
        String query = "DELETE FROM APP.ORDERDETAILS WHERE ORDER_ID ="+jTextField1.getText();
        
        if(count!=0){
            try {
                executeSQLQuery(query, "Delete");
                jTextField1.setText("");
                jTextField2.setText("");
//                jTextField3.setText("");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Query is not executed");
            }
        } else{
            JOptionPane.showMessageDialog(null, "Table is empty!");
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        int i = jXTable1.getSelectedRow();
        TableModel model = jXTable1.getModel();
        jTextField1.setText(model.getValueAt(i,0).toString());
        jTextField2.setText(model.getValueAt(i,5).toString());
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jXTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTable1MouseClicked
        // TODO add your handling code here:
        int i = jXTable1.getSelectedRow();
        String order_ID = jTextField1.getText();
        System.out.println("Order ID:"+order_ID);
        TableModel model = jXTable1.getModel();
        jTextField1.setText(model.getValueAt(i,0).toString());
        jTextField2.setText(model.getValueAt(i,5).toString());
    }//GEN-LAST:event_jXTable1MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
        int i = jXTable1.getSelectedRow();
        TableModel model = jXTable1.getModel();
        jTextField2.setText(model.getValueAt(i,5).toString());
        jTextField2.setText(model.getValueAt(i,5).toString());
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        // TODO add your handling code here:
        int i = jXTable1.getSelectedRow();
        TableModel model = jXTable1.getModel();
        jTextField1.setText(model.getValueAt(i,0).toString());
        jTextField2.setText(model.getValueAt(i,5).toString());
    }//GEN-LAST:event_jTextField2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(OrdersFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrdersFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrdersFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrdersFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrdersFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private org.jdesktop.swingx.JXTable jXTable1;
    // End of variables declaration//GEN-END:variables

    String setText(String username) 
    {       
        System.out.println(username);
        return username;
    }

    int setInt(int Cust_ID) 
    {
        System.out.println(Cust_ID);
        return Cust_ID;
    }

    private int setQuan(int Quan) {
        System.out.println(Quan);
        return Quan;
    }

    public static int setIntprod(int prod_ID) {
        System.out.println("Product ID:"+ prod_ID);
        return prod_ID;
    }
    
    public static int setorder(int prod_ID) {
        System.out.println("Product ID:"+ prod_ID);
        return prod_ID;
    }

    public int setran(int randnum) {
        System.out.println("Random number:"+ randnum);
        return randnum;
    }
}
