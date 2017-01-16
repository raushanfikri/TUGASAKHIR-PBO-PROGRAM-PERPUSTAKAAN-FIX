/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.MKategori;
import Koneksi.KoneksiDB;
/**
 *
 * @author microsoft
 */
public class CKategori {
    KoneksiDB koneksi = new KoneksiDB();
    
    
    public void simpanData(MKategori mk) {//memanggil kelas Model kesalahan dan membuat objek km
        koneksi.koneksiDatabase();
        String query = "insert into tbl_kategori(kodekategori, namakategori) values ('"
                +mk.getKodekategori()+"',"
                + "'"+mk.getNamakategori()+"')";
        try {
            koneksi.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil disimpan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Tidak berhasil disimpan");
            System.err.println(""+e);
        }

    }
    
    public void hapusData(MKategori mk) {
    try {
            koneksi.koneksiDatabase();
            String query = "delete from tbl_kategori where kodekategori=('"+mk.getKodekategori()+"')";
            koneksi.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus..");
            //koneksi.connect.close();
        } catch (SQLException e) {
            System.err.println("Error : "+e);
            JOptionPane.showMessageDialog(null, "Data TIDAK terhapus");
        }
    }
    
     public void ubahData(MKategori mk) {
         koneksi.koneksiDatabase();
         try {
            //int id = mp.getIdpelanggan();
            String kodekategori = mk.getKodekategori();
            String namakategori = mk.getNamakategori();
            
            String query = "update tbl_kategori "
                    
                    + "set kodekategori=('" + kodekategori+ "'),"
                    + "namakategori=('"+namakategori+"')"
                    + "where kodekategori=('" + kodekategori + "')";
            koneksi.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil DiUbah..");
        } catch (SQLException e) {
            System.err.println("Error : " + e);
            JOptionPane.showMessageDialog(null, "Data TIDAK terubah");
        }
    }
}
