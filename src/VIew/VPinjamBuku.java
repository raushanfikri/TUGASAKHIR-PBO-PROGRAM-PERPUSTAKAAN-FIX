/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIew;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import Controller.CPinjam;
import Koneksi.KoneksiDB;
import java.sql.PreparedStatement;
import java.sql.Connection;
import Model.MPinjam;
/**
 *
 * @author microsoft
 */
public class VPinjamBuku extends javax.swing.JFrame {
KoneksiDB koneksi = new KoneksiDB();
    MPinjam mb = new MPinjam();
    CPinjam cb = new CPinjam();
    
    PreparedStatement pst  = null;
    Connection conn = null;
    ResultSet rs = null;
    /**
     * Creates new form VPinjamBuku
     */
    public VPinjamBuku() {
        initComponents();
        dataTable();
        tutup();
    }

    private void bersih()
     {
        
        jTX_KODEBUKU.setText("");
        jTX_KODEPINJAM.setText("");
        jTX_NIS.setText("");
        jTX_NAMA.setText("");
        jTX_JUDUL.setText("");
        jTX_TANGGALPINJAM.setText("");
        jTX_TANGGALKEMBALI.setText("");
     }  
    
    
     private void tutup() {
       jBTN_NEW.setEnabled(true);
        jBTN_SAVE.setEnabled(false);
        jBTN_EDIT.setEnabled(false);
        jBTN_DELETE.setEnabled(false);
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jTX_KODEPINJAM.setEnabled(false);
        jTX_NIS.setEnabled(false);
        jTX_NAMA.setEnabled(false);
        jTX_KODEBUKU .setEnabled(false);
        jTX_JUDUL.setEnabled(false);
        jTX_TANGGALPINJAM.setEnabled(false);
        jTX_TANGGALKEMBALI.setEnabled(false);
        bersih();
    }
     
     private void buka() {
       jBTN_NEW.setEnabled(true);
        jBTN_SAVE.setEnabled(true);
        jBTN_EDIT.setEnabled(true);
        jBTN_DELETE.setEnabled(true);
       jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        jTX_KODEPINJAM.setEnabled(true);
        jTX_NIS.setEnabled(false);
        jTX_NAMA.setEnabled(false);
        jTX_KODEBUKU .setEnabled(false);
        jTX_JUDUL.setEnabled(false);
        jTX_TANGGALPINJAM.setEnabled(true);
        jTX_TANGGALKEMBALI.setEnabled(true);
        bersih();
    }
     
     
     private void kliktable(){
       try {
            int baris = jTB_PINJAM.getSelectedRow();
            jTX_KODEPINJAM.setText(jTB_PINJAM.getValueAt(baris, 0).toString());
            jTX_NIS.setText(jTB_PINJAM.getValueAt(baris, 1).toString());
            jTX_NAMA.setText(jTB_PINJAM.getValueAt(baris, 2).toString());
            jTX_KODEBUKU.setText(jTB_PINJAM.getValueAt(baris, 3).toString());
            jTX_JUDUL.setText(jTB_PINJAM.getValueAt(baris, 4).toString());
            jTX_TANGGALPINJAM.setText(jTB_PINJAM.getValueAt(baris, 5).toString());
            jTX_TANGGALKEMBALI.setText(jTB_PINJAM.getValueAt(baris, 6).toString());
           
            
       } catch (Exception e) {
       }
   }
     
      private void dataTable() {
        koneksi.koneksiDatabase();

        DefaultTableModel tabel = new DefaultTableModel();
        
    
        tabel.addColumn("Kode Pinjam");
        tabel.addColumn("NIS");
        tabel.addColumn("Nama");
        tabel.addColumn("Kode Buku ");
        tabel.addColumn("Judul ");
        tabel.addColumn("Tanggal Pinjam");
        tabel.addColumn("Tanggal Kembali");
       
       

        jTB_PINJAM.setModel(tabel);
        try {
            String sql = "select * from tbl_pinjam1";

            ResultSet res = koneksi.state.executeQuery(sql);
            while (res.next()) {
                tabel.addRow(new Object[]{
                    
                    res.getString("id_pinjam"),
                    res.getString("nis"),
                    res.getString("nama"),
                    res.getString("kodebuku"),
                    res.getString("judul"),
                    res.getString("tanggalpinjam"),
                    res.getString("tanggalkenbali"),
                          
                        
                });
                jTB_PINJAM.setModel(tabel);

            }
        } catch (SQLException eer) {
            System.err.println("SQLException:" + eer.getMessage());
        }
    }
     
     private void simpan(){
         try {
            //int id  = Integer.parseInt(jTX_ID.getText());
            String idpinjam = jTX_KODEPINJAM.getText();
            String  nis = jTX_NIS.getText();
            String nama= jTX_NAMA.getText();
            String kodebuku= jTX_KODEBUKU.getText();
            String judul = jTX_JUDUL.getText();
            String tanggalpinjam = jTX_TANGGALPINJAM.getText();
            String tanggalkembali = jTX_TANGGALKEMBALI.getText();
           

            //mt.setId(id);
            mb.setIdpinjam(idpinjam);
            mb.setNis(nis);
            mb.setNama(nama);
            mb.setKodebuku(kodebuku);
            mb.setJudul(judul);
            mb.setTanggalpinjam(tanggalpinjam);
            mb.setTanggalkembali(tanggalkembali);
        

            cb.simpanData(mb);

            dataTable();

            
        } catch (Exception e) {
            System.err.println("" + e);
        }
   }
     
     private void ubah(){
         try {
            //int id  = Integer.parseInt(jTX_ID.getText());
            String idpinjam = jTX_KODEPINJAM.getText();
            String nis = jTX_NIS.getText();
            String nama= jTX_NAMA.getText();
            String kodebuku= jTX_KODEBUKU.getText();
            String judul = jTX_JUDUL.getText();
            String tanggalpinjam = jTX_TANGGALPINJAM.getText();
            String tanggalkembali = jTX_TANGGALKEMBALI.getText();
           

            //mt.setId(id);
            mb.setIdpinjam(idpinjam);
            mb.setNis(nis);
            mb.setNama(nama);
            mb.setKodebuku(kodebuku);
            mb.setJudul(judul);
            mb.setTanggalpinjam(tanggalpinjam);
            mb.setTanggalkembali(tanggalkembali);
        

            cb.ubahData(mb);

            dataTable();

            
        } catch (Exception e) {
            System.err.println("" + e);
        }
   }
     
     public void hapus(){
       try {
            String kodepinjam = jTX_KODEPINJAM.getText();
            
            mb.setIdpinjam(kodepinjam);//mt didapat dari pembuatan objek, dari kelas ModelTeman (instansiasi dilakukan diatas)
            
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

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTB_PINJAM = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jBTN_NEW = new javax.swing.JButton();
        jBTN_SAVE = new javax.swing.JButton();
        jBTN_EDIT = new javax.swing.JButton();
        jBTN_DELETE = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTX_JUDUL = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTX_TANGGALPINJAM = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTX_TANGGALKEMBALI = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTX_KODEPINJAM = new javax.swing.JTextField();
        jTX_NIS = new javax.swing.JTextField();
        jTX_NAMA = new javax.swing.JTextField();
        jTX_KODEBUKU = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form PEminjaman BUku");

        jTB_PINJAM.setModel(new javax.swing.table.DefaultTableModel(
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
        jTB_PINJAM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTB_PINJAMMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTB_PINJAM);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBTN_DELETE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBTN_EDIT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBTN_SAVE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBTN_NEW, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBTN_NEW)
                .addGap(18, 18, 18)
                .addComponent(jBTN_SAVE)
                .addGap(18, 18, 18)
                .addComponent(jBTN_EDIT)
                .addGap(18, 18, 18)
                .addComponent(jBTN_DELETE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Kode Pinjam");

        jLabel2.setText("NIS");

        jLabel3.setText("Nama");

        jLabel4.setText("Kode Buku");

        jLabel5.setText("Judul Buku");

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Tanggal Pinjam");

        jButton2.setText("...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setText("Tanggal Kembali");

        jTX_NAMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTX_NAMAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTX_TANGGALPINJAM, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jTX_TANGGALKEMBALI, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTX_JUDUL, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTX_NAMA, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTX_NIS, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTX_KODEPINJAM, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTX_KODEBUKU, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTX_KODEPINJAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jTX_NIS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTX_NAMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jTX_KODEBUKU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTX_JUDUL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTX_TANGGALPINJAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTX_TANGGALKEMBALI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("Data Peminjaman Buku Perpustakaan");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel9.setText("Data tentang peminjaman buku perpustakaan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTX_NAMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTX_NAMAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTX_NAMAActionPerformed

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

    private void jTB_PINJAMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTB_PINJAMMouseClicked
        // TODO add your handling code here:
        kliktable();
    }//GEN-LAST:event_jTB_PINJAMMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        VBukuSearch pinjam = new VBukuSearch();
        pinjam.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         VSiswaSeacrh siswasearch = new VSiswaSeacrh();
         siswasearch.setVisible(true);
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
            java.util.logging.Logger.getLogger(VPinjamBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VPinjamBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VPinjamBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VPinjamBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VPinjamBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBTN_DELETE;
    private javax.swing.JButton jBTN_EDIT;
    private javax.swing.JButton jBTN_NEW;
    private javax.swing.JButton jBTN_SAVE;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTB_PINJAM;
    public static javax.swing.JTextField jTX_JUDUL;
    public static javax.swing.JTextField jTX_KODEBUKU;
    private javax.swing.JTextField jTX_KODEPINJAM;
    public static javax.swing.JTextField jTX_NAMA;
    public static javax.swing.JTextField jTX_NIS;
    private javax.swing.JTextField jTX_TANGGALKEMBALI;
    private javax.swing.JTextField jTX_TANGGALPINJAM;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
