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
import Controller.CSiswa;
import Koneksi.KoneksiDB;
import java.sql.PreparedStatement;
import java.sql.Connection;
import Model.MSiswa;
/**
 *
 * @author microsoft
 */
public class VSiswaTable extends javax.swing.JFrame {
KoneksiDB koneksi = new KoneksiDB();
    MSiswa mb = new MSiswa();
    CSiswa cb = new CSiswa();
    
    PreparedStatement pst  = null;
    Connection conn = null;
    ResultSet rs = null;
    /**
     * Creates new form VSiswaTable
     */
    public VSiswaTable() {
        initComponents();
        dataTable();
    }
    
    private void bersih(){
    jTX_NIS.setText("");
        jTX_NAMA.setText("");
        jTX_KELAS.setText("");
        jTX_JENISKELAMIN.setText("");
        jTX_TEMPATLAHIR .setText("");
        jTX_TANGGALLAHIR.setText("");
        jTX_ALAMAT.setText("");
        jTX_NOMORTELP.setText("");
        jTX_TANGGALREGISTER.setText("");
        jTX_AKHIRREGISTER.setText("");

}
    
    private void dataTable() {
        koneksi.koneksiDatabase();
        
        DefaultTableModel tabel = new DefaultTableModel();
        
    
        tabel.addColumn("NIS");
        tabel.addColumn("Nama");
        tabel.addColumn("Kelas");
        tabel.addColumn("Jenis Kelamin ");
        tabel.addColumn("Tempat Lahit");
        tabel.addColumn("Tanggal Lahir");
        tabel.addColumn("Alamat ");
        tabel.addColumn("Nomor Telepon");
        tabel.addColumn("Tanggal Register");
        tabel.addColumn("Akhir Register");
        
        jTB_SISWA.setModel(tabel);
        try {
            String sql = "select * from tbl_siswa ";

            ResultSet res = koneksi.state.executeQuery(sql);
            while (res.next()) {
                tabel.addRow(new Object[]{
                    
                    res.getString("nis"),
                    res.getString("nama"),
                    res.getString("kelas"),
                    res.getString("jeniskelamin"),
                    res.getString("kotalahir"),
                    res.getString("tanggallahir"),
                    res.getString("alamat"),
                    res.getString("telepon"),       
                    res.getString("tanggalregister"),  
                    res.getString("akhiregister"),  
                    
                });
                jTB_SISWA.setModel(tabel);

            }
        } catch (SQLException eer) {
            System.err.println("SQLException:" + eer.getMessage());
        }
    }
    private void kliktable(){
       try {
            int baris = jTB_SISWA.getSelectedRow();
            jTX_NIS.setText(jTB_SISWA.getValueAt(baris, 0).toString());
            jTX_NAMA.setText(jTB_SISWA.getValueAt(baris, 1).toString());
            jTX_KELAS.setText(jTB_SISWA.getValueAt(baris, 2).toString());
            jTX_JENISKELAMIN.setText(jTB_SISWA.getValueAt(baris, 3).toString());
            jTX_TEMPATLAHIR.setText(jTB_SISWA.getValueAt(baris, 4).toString());
            jTX_TANGGALLAHIR.setText(jTB_SISWA.getValueAt(baris, 5).toString());
            jTX_ALAMAT.setText(jTB_SISWA.getValueAt(baris, 6).toString());
            jTX_NOMORTELP.setText(jTB_SISWA.getValueAt(baris, 7).toString());
            jTX_TANGGALREGISTER.setText(jTB_SISWA.getValueAt(baris, 8).toString());
            jTX_AKHIRREGISTER.setText(jTB_SISWA.getValueAt(baris, 9).toString());
            
       } catch (Exception e) {
       }
   }
    
    private void ubah(){
         try {
            //int id  = Integer.parseInt(jTX_ID.getText());
            String nis = jTX_NIS.getText();
            String nama =jTX_NAMA.getText();
            String kelas=jTX_KELAS.getText();
            String jeniskelamin= jTX_JENISKELAMIN.getText();
            String kotalahir = jTX_TEMPATLAHIR.getText();
            String tanggallahir = jTX_TANGGALLAHIR.getText();
            String alamat = jTX_ALAMAT.getText();
            String telepon = jTX_NOMORTELP.getText();
            String tanggalregister = jTX_TANGGALREGISTER.getText();
            String akhirregister = jTX_AKHIRREGISTER.getText();

            //mt.setId(id);
            mb.setNis(nis);
            mb.setNama(nama);
            mb.setKelas(kelas);
            mb.setJeniskelamin(jeniskelamin);
            mb.setKotalahir(kotalahir);
            mb.setTanggallahir(tanggallahir);
            mb.setAlamat(alamat);
            mb.setTelepon(telepon);
            mb.setTanggalregister(tanggalregister);
            mb.setAkhirregister(akhirregister);

            cb.ubahData(mb);

            

            
        } catch (Exception e) {
            System.err.println("" + e);
        }
   }
    
    public void hapus(){
       try {
            String nis = jTX_NIS.getText();
            
            mb.setNis(nis);//mt didapat dari pembuatan objek, dari kelas ModelTeman (instansiasi dilakukan diatas)
            
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

        jLabel1 = new javax.swing.JLabel();
        jTX_NIS = new javax.swing.JTextField();
        jTX_NAMA = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTX_KELAS = new javax.swing.JTextField();
        jTX_JENISKELAMIN = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTX_TEMPATLAHIR = new javax.swing.JTextField();
        jTX_TANGGALLAHIR = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTX_ALAMAT = new javax.swing.JTextField();
        jTX_NOMORTELP = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTX_TANGGALREGISTER = new javax.swing.JTextField();
        jTX_AKHIRREGISTER = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTB_SISWA = new javax.swing.JTable();
        jBTN_EDIT = new javax.swing.JButton();
        jBTN_DELETE = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Daftar Siswa");

        jLabel1.setText("NIS");

        jLabel2.setText("Nama");

        jLabel3.setText("Kelas");

        jTX_KELAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTX_KELASActionPerformed(evt);
            }
        });

        jLabel4.setText("Jenis Kelamin");

        jLabel5.setText("Tempat Lahir");

        jLabel6.setText("Tanggal Lahir");

        jLabel7.setText("Alamat");

        jTX_ALAMAT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTX_ALAMATActionPerformed(evt);
            }
        });

        jLabel8.setText("No Telepon");

        jLabel9.setText("Tanggal Register");

        jLabel10.setText("Akhir Register");

        jTB_SISWA.setModel(new javax.swing.table.DefaultTableModel(
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
        jTB_SISWA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTB_SISWAMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTB_SISWA);

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

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel11.setText("Daftar Siswa ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jBTN_EDIT, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jBTN_DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1)))
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTX_TANGGALREGISTER, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTX_KELAS, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTX_NIS, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTX_TEMPATLAHIR, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTX_NAMA, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTX_ALAMAT, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTX_NOMORTELP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTX_TANGGALLAHIR, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTX_JENISKELAMIN, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTX_AKHIRREGISTER, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(119, 119, 119)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jTX_NIS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTX_NAMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTX_KELAS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTX_JENISKELAMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTX_TEMPATLAHIR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTX_TANGGALLAHIR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTX_ALAMAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTX_NOMORTELP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTX_TANGGALREGISTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTX_AKHIRREGISTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBTN_EDIT)
                    .addComponent(jBTN_DELETE))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTX_KELASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTX_KELASActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTX_KELASActionPerformed

    private void jTX_ALAMATActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTX_ALAMATActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTX_ALAMATActionPerformed

    private void jTB_SISWAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTB_SISWAMouseClicked
        // TODO add your handling code here:
        kliktable();
    }//GEN-LAST:event_jTB_SISWAMouseClicked

    private void jBTN_EDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTN_EDITActionPerformed
        // TODO add your handling code here:
        ubah();
        bersih();
    }//GEN-LAST:event_jBTN_EDITActionPerformed

    private void jBTN_DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTN_DELETEActionPerformed
        // TODO add your handling code here:
        hapus();
        bersih();
    }//GEN-LAST:event_jBTN_DELETEActionPerformed

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
            java.util.logging.Logger.getLogger(VSiswaTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VSiswaTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VSiswaTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VSiswaTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VSiswaTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBTN_DELETE;
    private javax.swing.JButton jBTN_EDIT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTB_SISWA;
    private javax.swing.JTextField jTX_AKHIRREGISTER;
    private javax.swing.JTextField jTX_ALAMAT;
    private javax.swing.JTextField jTX_JENISKELAMIN;
    private javax.swing.JTextField jTX_KELAS;
    private javax.swing.JTextField jTX_NAMA;
    private javax.swing.JTextField jTX_NIS;
    private javax.swing.JTextField jTX_NOMORTELP;
    private javax.swing.JTextField jTX_TANGGALLAHIR;
    private javax.swing.JTextField jTX_TANGGALREGISTER;
    private javax.swing.JTextField jTX_TEMPATLAHIR;
    // End of variables declaration//GEN-END:variables
}
