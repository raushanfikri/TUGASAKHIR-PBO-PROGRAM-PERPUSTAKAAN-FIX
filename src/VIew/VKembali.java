/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIew;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Controller.CKembali;
import Koneksi.KoneksiDB;
import java.sql.PreparedStatement;
import java.sql.Connection;
import Model.MKembali;
/**
 *
 * @author microsoft
 */
public class VKembali extends javax.swing.JFrame {
KoneksiDB koneksi = new KoneksiDB();
    MKembali mb = new MKembali();
    CKembali cb = new CKembali();
    
    PreparedStatement pst  = null;
    Connection conn = null;
    ResultSet rs = null;
    /**
     * Creates new form VKembali
     */
    public VKembali() {
        initComponents();
        dataTable();
        tutup();
        
    }
    
     private void bersih()
     {
        
        jTX_KODEPENGEMBALIAN.setText("");
        jTX_KODEPINJAM.setText("");
        jTX_TANGGALKEMBALI.setText("");
        jTX_TERLAMBAT.setText("");
        jTX_DENDA.setText("");
        
        
     }  
     
      private void tutup() {
       jBTN_NEW.setEnabled(true);
        jBTN_SAVE.setEnabled(false);
        jBTN_EDIT.setEnabled(false);
        jBTN_DELETE.setEnabled(false);
        jTX_KODEPENGEMBALIAN.setEnabled(false);
        jTX_KODEPINJAM.setEnabled(false);
        jTX_TANGGALKEMBALI.setEnabled(false);
        jTX_TERLAMBAT.setEnabled(false);
        jTX_DENDA.setEnabled(false);
      
      }
      
      private void buka() {
       jBTN_NEW.setEnabled(true);
        jBTN_SAVE.setEnabled(true);
        jBTN_EDIT.setEnabled(true);
        jBTN_DELETE.setEnabled(true);
        jTX_KODEPENGEMBALIAN.setEnabled(true);
        jTX_KODEPINJAM.setEnabled(false);
        jTX_TANGGALKEMBALI.setEnabled(false);
        jTX_TERLAMBAT.setEnabled(true);
        jTX_DENDA.setEnabled(true);
      
      }
      
      private void kliktable(){
       try {
            int baris = jTB_KEMBALI.getSelectedRow();
            jTX_KODEPENGEMBALIAN.setText(jTB_KEMBALI.getValueAt(baris, 0).toString());
            jTX_KODEPINJAM.setText(jTB_KEMBALI.getValueAt(baris, 1).toString());
            jTX_TANGGALKEMBALI.setText(jTB_KEMBALI.getValueAt(baris, 2).toString());
            jTX_TERLAMBAT.setText(jTB_KEMBALI.getValueAt(baris, 3).toString());
            jTX_DENDA.setText(jTB_KEMBALI.getValueAt(baris, 4).toString());          
            
       } catch (Exception e) {
       }
      }
      
      private void dataTable() {
        koneksi.koneksiDatabase();

        DefaultTableModel tabel = new DefaultTableModel();
        
    
        tabel.addColumn("Kode Pengembalian");
        tabel.addColumn("Kode Peminjaman");
        tabel.addColumn("Tanggal Pengembalian");
        tabel.addColumn("Terlambat ");
        tabel.addColumn("Denda ");
       
       
       

        jTB_KEMBALI.setModel(tabel);
        try {
            String sql = "select * from tbl_kembali";

            ResultSet res = koneksi.state.executeQuery(sql);
            while (res.next()) {
                tabel.addRow(new Object[]{
                    
                    res.getString("id_pengembalian"),
                    res.getString("id_pinjam"),
                    res.getString("tanggalkembali"),
                    res.getString("terlambat"),
                    res.getString("denda"),
                    
                          
                        
                });
                jTB_KEMBALI.setModel(tabel);

            }
        } catch (SQLException eer) {
            System.err.println("SQLException:" + eer.getMessage());
        }
    }
      
      private void simpan(){
         try {
            //int id  = Integer.parseInt(jTX_ID.getText());
            String  idpengembalian = jTX_KODEPENGEMBALIAN.getText();
            String  idpinjam = jTX_KODEPINJAM.getText();
            String tanggalkembali = jTX_TANGGALKEMBALI.getText();
            int terlambat = Integer.parseInt(jTX_TERLAMBAT.getText());
            int denda = Integer.parseInt(jTX_DENDA.getText());
           
           

            //mt.setId(id);
            mb.setIdpengembalian(idpengembalian);
            mb.setIdpinjam(idpinjam);
            mb.setTanggalkembali(tanggalkembali);
            mb.setTerlambat(terlambat);
            mb.setDenda(denda);
        
            cb.simpanData(mb);

            dataTable();

            
        } catch (Exception e) {
            System.err.println("" + e);
        }
   }private void ubah(){
         try {
            //int id  = Integer.parseInt(jTX_ID.getText());
            String  idpengembalian = jTX_KODEPENGEMBALIAN.getText();
            String  idpinjam = jTX_KODEPINJAM.getText();
            String tanggalkembali = jTX_TANGGALKEMBALI.getText();
            int terlambat = Integer.parseInt(jTX_TERLAMBAT.getText());
            int denda = Integer.parseInt(jTX_DENDA.getText());
           
           

            //mt.setId(id);
            mb.setIdpengembalian(idpengembalian);
            mb.setIdpinjam(idpinjam);
            mb.setTanggalkembali(tanggalkembali);
            mb.setTerlambat(terlambat);
            mb.setDenda(denda);
        
            cb.ubahData(mb);

            dataTable();

            
        } catch (Exception e) {
            System.err.println("" + e);
        }
   }
   
   public void hapus(){
       try {
            String idpengembalian= jTX_KODEPENGEMBALIAN.getText();
            
            mb.setIdpinjam(idpengembalian);//mt didapat dari pembuatan objek, dari kelas ModelTeman (instansiasi dilakukan diatas)
            
            cb.hapusData(mb);//ct didapat dari pembuatan objek, dari kelas ControllerTeman (instansiasi dilakukan diatas)
            
            dataTable();
            
        } catch (NullPointerException e) {
            
        }
      }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTX_KODEPENGEMBALIAN = new javax.swing.JTextField();
        jTX_KODEPINJAM = new javax.swing.JTextField();
        jTX_TANGGALKEMBALI = new javax.swing.JTextField();
        jTX_TERLAMBAT = new javax.swing.JTextField();
        jTX_DENDA = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTB_KEMBALI = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jBTN_NEW = new javax.swing.JButton();
        jBTN_SAVE = new javax.swing.JButton();
        jBTN_EDIT = new javax.swing.JButton();
        jBTN_DELETE = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Pengembalian Buku");

        jLabel1.setText("Kode Pengembalian");

        jLabel2.setText("Kode Pinjam");

        jLabel3.setText("Tanggal Kembali");

        jLabel4.setText("Terlambat");

        jLabel5.setText("Denda");

        jTX_KODEPINJAM.setEnabled(false);
        jTX_KODEPINJAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTX_KODEPINJAMActionPerformed(evt);
            }
        });

        jTX_TANGGALKEMBALI.setEnabled(false);

        jTX_DENDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTX_DENDAActionPerformed(evt);
            }
        });

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTX_KODEPINJAM, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTX_KODEPENGEMBALIAN, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(157, 157, 157))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTX_TANGGALKEMBALI, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTX_TERLAMBAT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(245, 245, 245))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTX_DENDA, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(194, 194, 194))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTX_KODEPENGEMBALIAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jTX_KODEPINJAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTX_TANGGALKEMBALI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTX_TERLAMBAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTX_DENDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jTB_KEMBALI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTB_KEMBALI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTB_KEMBALIMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTB_KEMBALI);

        jBTN_NEW.setText("NEW");
        jBTN_NEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTN_NEWActionPerformed(evt);
            }
        });

        jBTN_SAVE.setText("SAVE");
        jBTN_SAVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTN_SAVEActionPerformed(evt);
            }
        });

        jBTN_EDIT.setText("EDIT");
        jBTN_EDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTN_EDITActionPerformed(evt);
            }
        });

        jBTN_DELETE.setText("DELETE");
        jBTN_DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTN_DELETEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBTN_DELETE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBTN_EDIT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBTN_SAVE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBTN_NEW, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBTN_NEW)
                .addGap(11, 11, 11)
                .addComponent(jBTN_SAVE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBTN_EDIT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBTN_DELETE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("Data Pengembalian Buku Perpustakaan");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel7.setText("Data tentang pengembalian buku perpustakaan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTX_DENDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTX_DENDAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTX_DENDAActionPerformed

    private void jTX_KODEPINJAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTX_KODEPINJAMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTX_KODEPINJAMActionPerformed

    private void jTB_KEMBALIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTB_KEMBALIMouseClicked
        // TODO add your handling code here:
        kliktable();
    }//GEN-LAST:event_jTB_KEMBALIMouseClicked

    private void jBTN_NEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTN_NEWActionPerformed
        // TODO add your handling code here:
        buka();
    }//GEN-LAST:event_jBTN_NEWActionPerformed

    private void jBTN_SAVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTN_SAVEActionPerformed
        // TODO add your handling code here:
        simpan();
        bersih();
    }//GEN-LAST:event_jBTN_SAVEActionPerformed

    private void jBTN_EDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTN_EDITActionPerformed
        // TODO add your handling code here:
        ubah();
        bersih();
                
    }//GEN-LAST:event_jBTN_EDITActionPerformed

    private void jBTN_DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTN_DELETEActionPerformed
        // TODO add your handling code here:
        hapus();
    }//GEN-LAST:event_jBTN_DELETEActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        VPinjamBukuSearch pinjambukusearch = new VPinjamBukuSearch();
        pinjambukusearch.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(VKembali.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VKembali.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VKembali.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VKembali.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VKembali().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBTN_DELETE;
    private javax.swing.JButton jBTN_EDIT;
    private javax.swing.JButton jBTN_NEW;
    private javax.swing.JButton jBTN_SAVE;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTB_KEMBALI;
    private javax.swing.JTextField jTX_DENDA;
    private javax.swing.JTextField jTX_KODEPENGEMBALIAN;
    public static javax.swing.JTextField jTX_KODEPINJAM;
    public static javax.swing.JTextField jTX_TANGGALKEMBALI;
    private javax.swing.JTextField jTX_TERLAMBAT;
    // End of variables declaration//GEN-END:variables
}
