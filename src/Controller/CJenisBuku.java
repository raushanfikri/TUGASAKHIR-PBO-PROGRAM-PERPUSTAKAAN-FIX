/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.MJenisBuku;
import Koneksi.KoneksiDB;
/**
 *
 * @author microsoft
 */
public class CJenisBuku {
     KoneksiDB koneksi = new KoneksiDB();

    public void simpanData(MJenisBuku mjb) {//memanggil kelas Model kesalahan dan membuat objek km
        koneksi.koneksiDatabase();
        String query = "insert into tbl_jenis(kodejenis, namajenis) values ('"
                +mjb.getKodejenis()+"',"
                + "'"+mjb.getNamajenis()+"')";
        try {
            koneksi.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil disimpan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Tidak berhasil disimpan");
            System.err.println(""+e);
        }

    }
    
    public void hapusData(MJenisBuku mjb) {
    try {
            koneksi.koneksiDatabase();
            String query = "delete from tbl_jenis where kodejenis=('"+mjb.getKodejenis()+"')";
            koneksi.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus..");
            //koneksi.connect.close();
        } catch (SQLException e) {
            System.err.println("Error : "+e);
            JOptionPane.showMessageDialog(null, "Data TIDAK terhapus");
        }
    }
    
     public void ubahData(MJenisBuku mjb) {
         koneksi.koneksiDatabase();
         try {
            //int id = mp.getIdpelanggan();
            String kodejenis = mjb.getKodejenis();
            String namajenis = mjb.getNamajenis();
            
            String query = "update tbl_buku "
                    
                    + "set kodejenis=('" + kodejenis+ "'),"
                    + "namajenis=('"+namajenis+"')"
                    + "where kodejenis=('" + kodejenis + "')";
            koneksi.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil DiUbah..");
        } catch (SQLException e) {
            System.err.println("Error : " + e);
            JOptionPane.showMessageDialog(null, "Data TIDAK terubah");
        }
    }
}
