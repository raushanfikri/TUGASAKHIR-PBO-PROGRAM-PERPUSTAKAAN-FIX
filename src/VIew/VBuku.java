/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIew;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;
import Controller.CBuku;
import Koneksi.KoneksiDB;
import java.sql.PreparedStatement;
import java.sql.Connection;
import Model.MBuku;


/**
 *
 * @author microsoft
 */
public class VBuku extends javax.swing.JFrame {
KoneksiDB koneksi = new KoneksiDB();
    MBuku mb = new MBuku();
    CBuku cb = new CBuku();
    
    PreparedStatement pst  = null;
    Connection conn = null;
    ResultSet rs = null;
    /**
     * Creates new form VBuku
     */
    public VBuku() {
        initComponents();
         setLocationRelativeTo(null);
        dataTable();
        tutup();
        
    }
     private void bersih()
     {
        
        jTX_KODEBUKU.setText("");
        jTX_KODEJENISBUKU.setText("");
        jTX_KODEKATEGORIBUKU.setText("");
        jTX_JUDULBUKU.setText("");
        jTX_PENGARANGBUKU.setText("");
        jTX_KODEPENERBIT.setText("");
        jTX_TAHUN.setText("");
        jTX_JUMLAHBUKU.setText("");
     
     }
     private void tutup() {
       jBTN_NEW.setEnabled(true);
        jBTN_SAVE.setEnabled(false);
        jBTN_EDIT.setEnabled(false);
        jBTN_DELETE.setEnabled(false);
        jBTN_KODEJENISBUKU.setEnabled(false);
        jBTN_KODEKATEGORIBUKU.setEnabled(false);
        jBTN_KODEPENERBIT.setEnabled(false);
        jTX_KODEBUKU.setEnabled(false);
        jTX_KODEJENISBUKU.setEnabled(false);
        jTX_KODEKATEGORIBUKU.setEnabled(false);
        jTX_JUDULBUKU.setEnabled(false);
        jTX_PENGARANGBUKU .setEnabled(false);
        jTX_KODEPENERBIT.setEnabled(false);
        jTX_TAHUN.setEnabled(false);
        jTX_JUMLAHBUKU.setEnabled(false);
        bersih();
    }
      private void buka() {
       jBTN_NEW.setEnabled(true);
        jBTN_SAVE.setEnabled(true);
        jBTN_EDIT.setEnabled(true);
        jBTN_DELETE.setEnabled(true);
        jBTN_KODEJENISBUKU.setEnabled(true);
        jBTN_KODEKATEGORIBUKU.setEnabled(true);
        jBTN_KODEPENERBIT.setEnabled(true);
        jTX_KODEBUKU.setEnabled(true);
        jTX_KODEJENISBUKU.setEnabled(false);
        jTX_KODEKATEGORIBUKU.setEnabled(false);
        jTX_JUDULBUKU.setEnabled(true);
        jTX_PENGARANGBUKU .setEnabled(true );
        jTX_KODEPENERBIT.setEnabled(false);
        jTX_TAHUN.setEnabled(true);
        jTX_JUMLAHBUKU.setEnabled(true);
        bersih();
    }
    private void kliktable(){
       try {
            int baris = jTB_BUKU.getSelectedRow();
            jTX_KODEBUKU.setText(jTB_BUKU.getValueAt(baris, 0).toString());
            jTX_KODEJENISBUKU.setText(jTB_BUKU.getValueAt(baris, 1).toString());
            jTX_KODEKATEGORIBUKU.setText(jTB_BUKU.getValueAt(baris, 2).toString());
            jTX_JUDULBUKU.setText(jTB_BUKU.getValueAt(baris, 3).toString());
            jTX_PENGARANGBUKU.setText(jTB_BUKU.getValueAt(baris, 4).toString());
            jTX_KODEPENERBIT.setText(jTB_BUKU.getValueAt(baris, 5).toString());
            jTX_TAHUN.setText(jTB_BUKU.getValueAt(baris, 6).toString());
            jTX_JUMLAHBUKU.setText(jTB_BUKU.getValueAt(baris, 7).toString());
            
       } catch (Exception e) {
       }
   }
    private void dataTable() {
        koneksi.koneksiDatabase();

        DefaultTableModel tabel = new DefaultTableModel();
        
    
        tabel.addColumn("Kode Buku");
        tabel.addColumn("Kode Jenis Buku");
        tabel.addColumn("Kode Kategori Buku");
        tabel.addColumn("Judul Buku ");
        tabel.addColumn("Pengarang");
        tabel.addColumn("Kode Penerbit");
        tabel.addColumn("Tahun Terbit");
        tabel.addColumn("Jumlah Buku");
       

        jTB_BUKU.setModel(tabel);
        try {
            String sql = "select * from tbl_buku";

            ResultSet res = koneksi.state.executeQuery(sql);
            while (res.next()) {
                tabel.addRow(new Object[]{
                    
                    res.getString("kodebuku"),
                    res.getString("kodejenis"),
                    res.getString("kodekategori"),
                    res.getString("judul"),
                    res.getString("pengarang"),
                    res.getString("kodepenerbit"),
                    res.getString("tahun"),
                    res.getString("jumlahbuku"),       
                        
                });
                jTB_BUKU.setModel(tabel);

            }
        } catch (SQLException eer) {
            System.err.println("SQLException:" + eer.getMessage());
        }
    }
    
    private void simpan(){
         try {
            //int id  = Integer.parseInt(jTX_ID.getText());
            String kodebuku = jTX_KODEBUKU.getText();
            String kodejenis = jTX_KODEJENISBUKU.getText();
            String kodekategori= jTX_KODEKATEGORIBUKU.getText();
            String judul= jTX_JUDULBUKU.getText();
            String pengarang = jTX_PENGARANGBUKU.getText();
            String kodepenerbit = jTX_KODEPENERBIT.getText();
            String tahun = jTX_TAHUN.getText();
            int jumlahbuku =Integer.parseInt(jTX_KODEBUKU.getText());

            //mt.setId(id);
            mb.setKodebuku(kodebuku);
            mb.setKodejenis(kodejenis);
            mb.setKodekategori(kodekategori);
            mb.setJudul(judul);
            mb.setPengarang(pengarang);
            mb.setKodepenerbit(kodepenerbit);
            mb.setTahun(tahun);
            mb.setJumlahbuku(jumlahbuku);

            cb.simpanData(mb);

            dataTable();

            
        } catch (Exception e) {
            System.err.println("" + e);
        }
   }
    
    private void edit(){
         try {
            //int id  = Integer.parseInt(jTX_ID.getText());
            String kodebuku = jTX_KODEBUKU.getText();
            String kodejenis = jTX_KODEJENISBUKU.getText();
            String kodekategori= jTX_KODEKATEGORIBUKU.getText();
            String judul= jTX_JUDULBUKU.getText();
            String pengarang = jTX_PENGARANGBUKU.getText();
            String kodepenerbit = jTX_KODEPENERBIT.getText();
            String tahun = jTX_TAHUN.getText();
            int jumlahbuku =Integer.parseInt(jTX_JUMLAHBUKU.getText());

            //mt.setId(id);
            mb.setKodebuku(kodebuku);
            mb.setKodejenis(kodejenis);
            mb.setKodekategori(kodekategori);
            mb.setJudul(judul);
            mb.setPengarang(pengarang);
            mb.setKodepenerbit(kodepenerbit);
            mb.setTahun(tahun);
            mb.setJumlahbuku(jumlahbuku);

            cb.ubahData(mb);

            dataTable();

            
        } catch (Exception e) {
            System.err.println("" + e);
        }
   }
    
    
    public void hapus(){
       try {
            String kodebuku = jTX_KODEBUKU.getText();
            
            mb.setKodebuku(kodebuku);//mt didapat dari pembuatan objek, dari kelas ModelTeman (instansiasi dilakukan diatas)
            
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTX_KODEBUKU = new javax.swing.JTextField();
        jTX_KODEJENISBUKU = new javax.swing.JTextField();
        jTX_KODEKATEGORIBUKU = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTX_KODEPENERBIT = new javax.swing.JTextField();
        jBTN_KODEJENISBUKU = new javax.swing.JButton();
        jBTN_KODEKATEGORIBUKU = new javax.swing.JButton();
        jBTN_KODEPENERBIT = new javax.swing.JButton();
        jBTN_NEW = new javax.swing.JButton();
        jBTN_SAVE = new javax.swing.JButton();
        jBTN_EDIT = new javax.swing.JButton();
        jBTN_DELETE = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTX_JUDULBUKU = new javax.swing.JTextField();
        jTX_PENGARANGBUKU = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTX_TAHUN = new javax.swing.JTextField();
        jTX_JUMLAHBUKU = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTB_BUKU = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Buku");

        jLabel1.setText("Kode Buku");

        jLabel2.setText("Kode Jenis Buku");

        jLabel3.setText("Kode Kategori Buku");

        jTX_KODEJENISBUKU.setEnabled(false);

        jTX_KODEKATEGORIBUKU.setEnabled(false);

        jLabel6.setText("Kode Penerbit ");

        jTX_KODEPENERBIT.setEnabled(false);

        jBTN_KODEJENISBUKU.setText("...");
        jBTN_KODEJENISBUKU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTN_KODEJENISBUKUActionPerformed(evt);
            }
        });

        jBTN_KODEKATEGORIBUKU.setText("...");
        jBTN_KODEKATEGORIBUKU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTN_KODEKATEGORIBUKUActionPerformed(evt);
            }
        });

        jBTN_KODEPENERBIT.setText("...");
        jBTN_KODEPENERBIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTN_KODEPENERBITActionPerformed(evt);
            }
        });

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

        jLabel7.setText("Judul");

        jLabel8.setText("Pengarang");

        jLabel10.setText("Tahun");

        jLabel11.setText("Jumlah Buku");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTX_KODEKATEGORIBUKU, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTX_KODEBUKU, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                            .addComponent(jTX_KODEJENISBUKU))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jBTN_KODEJENISBUKU, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBTN_KODEKATEGORIBUKU, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTX_JUDULBUKU, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTX_PENGARANGBUKU)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jTX_KODEPENERBIT, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jBTN_KODEPENERBIT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel10))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTX_JUMLAHBUKU, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTX_TAHUN, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 70, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBTN_SAVE, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBTN_NEW, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBTN_DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBTN_EDIT, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTX_KODEBUKU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTX_KODEJENISBUKU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTX_JUDULBUKU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jBTN_SAVE)
                            .addComponent(jBTN_DELETE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBTN_KODEJENISBUKU, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jTX_PENGARANGBUKU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBTN_EDIT)
                            .addComponent(jBTN_NEW))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTX_KODEKATEGORIBUKU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBTN_KODEKATEGORIBUKU, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jTX_KODEPENERBIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBTN_KODEPENERBIT, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTX_TAHUN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTX_JUMLAHBUKU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTB_BUKU.setModel(new javax.swing.table.DefaultTableModel(
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
        jTB_BUKU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTB_BUKUMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTB_BUKU);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Daftar Buku Perpustakaan");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel5.setText("Daftar Buku yang Tersedia");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel9.setText("dan Terpinjam");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addComponent(jLabel9))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1053, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel4)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel9)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBTN_SAVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTN_SAVEActionPerformed
        // TODO add your handling code here:
        simpan();
        bersih();
    }//GEN-LAST:event_jBTN_SAVEActionPerformed

    private void jTB_BUKUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTB_BUKUMouseClicked
        // TODO add your handling code here:
        kliktable();
    }//GEN-LAST:event_jTB_BUKUMouseClicked

    private void jBTN_KODEPENERBITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTN_KODEPENERBITActionPerformed
        // TODO add your handling code here:
         VPenerbitSeacrh penerbitseacrh= new VPenerbitSeacrh();
         penerbitseacrh.setVisible(true);
    }//GEN-LAST:event_jBTN_KODEPENERBITActionPerformed

    private void jBTN_DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTN_DELETEActionPerformed
        // TODO add your handling code here:
       hapus();
       bersih();
    }//GEN-LAST:event_jBTN_DELETEActionPerformed

    private void jBTN_EDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTN_EDITActionPerformed
        // TODO add your handling code here:
        edit();
        bersih();
    }//GEN-LAST:event_jBTN_EDITActionPerformed

    private void jBTN_NEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTN_NEWActionPerformed
        // TODO add your handling code here:
        buka();
    }//GEN-LAST:event_jBTN_NEWActionPerformed

    private void jBTN_KODEJENISBUKUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTN_KODEJENISBUKUActionPerformed
        // TODO add your handling code here:
         VJenisBukuSeacrh jenisbukuseacrh= new VJenisBukuSeacrh();
         jenisbukuseacrh.setVisible(true);
    }//GEN-LAST:event_jBTN_KODEJENISBUKUActionPerformed

    private void jBTN_KODEKATEGORIBUKUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTN_KODEKATEGORIBUKUActionPerformed
        // TODO add your handling code here:
        VKategoriSearch kategoriseacrch = new VKategoriSearch();
        kategoriseacrch.setVisible(true);
    }//GEN-LAST:event_jBTN_KODEKATEGORIBUKUActionPerformed

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
            java.util.logging.Logger.getLogger(VBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBTN_DELETE;
    private javax.swing.JButton jBTN_EDIT;
    private javax.swing.JButton jBTN_KODEJENISBUKU;
    private javax.swing.JButton jBTN_KODEKATEGORIBUKU;
    private javax.swing.JButton jBTN_KODEPENERBIT;
    private javax.swing.JButton jBTN_NEW;
    private javax.swing.JButton jBTN_SAVE;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTB_BUKU;
    private javax.swing.JTextField jTX_JUDULBUKU;
    private javax.swing.JTextField jTX_JUMLAHBUKU;
    private javax.swing.JTextField jTX_KODEBUKU;
    public static javax.swing.JTextField jTX_KODEJENISBUKU;
    public static javax.swing.JTextField jTX_KODEKATEGORIBUKU;
    public static javax.swing.JTextField jTX_KODEPENERBIT;
    private javax.swing.JTextField jTX_PENGARANGBUKU;
    private javax.swing.JTextField jTX_TAHUN;
    // End of variables declaration//GEN-END:variables
}
