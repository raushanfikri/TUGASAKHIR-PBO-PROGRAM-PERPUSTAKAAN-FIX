/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.MKembali;
import Koneksi.KoneksiDB;
/**
 *
 * @author microsoft
 */
public class CKembali {
    KoneksiDB koneksi = new KoneksiDB();

    public void simpanData(MKembali mKE) {//memanggil kelas Model kesalahan dan membuat objek km
        koneksi.koneksiDatabase();
        String query = "insert into tbl_kembali(id_pengembalian, id_pinjam, tanggalkembali, terlambat, denda) values ('"
                +mKE.getIdpengembalian()+"',"
                + "'"+mKE.getIdpinjam()+"','"
                + "'"+mKE.getTanggalkembali()+"','"
                + "'"+mKE.getTerlambat()+"','"
                + "'"+mKE.getDenda()+"')";
        try {
            koneksi.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil disimpan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Tidak berhasil disimpan");
            System.err.println(""+e);
        }

    }
    
    public void hapusData(MKembali mKE) {
    try {
            koneksi.koneksiDatabase();
            String query = "delete from tbl_kembali where id_pengembalian=('"+mKE.getIdpengembalian()+"')";
            koneksi.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus..");
            //koneksi.connect.close();
        } catch (SQLException e) {
            System.err.println("Error : "+e);
            JOptionPane.showMessageDialog(null, "Data TIDAK terhapus");
        }
    }
    
    
    public void ubahData(MKembali mKE) {
         koneksi.koneksiDatabase();
         try {
            //int id = mp.getIdpelanggan();
            String id_pengembalian = mKE.getIdpengembalian();
            String id_pinjam = mKE.getIdpinjam();
            String tanggalkembali= mKE.getTanggalkembali();
            int terlambat= mKE.getTerlambat();
            int denda = mKE.getDenda();
            
            
            
            String query = "update tbl_kembali "
                    
                    + "set id_pengembalian=('" + id_pengembalian+ "'),"
                    + "id_pinjam=('" + id_pinjam+ "'),"
                    + "tanggalkembali=('"+ tanggalkembali+"'),"
                    + "terlambat=('"+ terlambat+"'),"
                    + "denda('"+denda+"')"
                    + "where id_pengembalian=('" + id_pengembalian + "')";
            koneksi.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil DiUbah..");
        } catch (SQLException e) {
            System.err.println("Error : " + e);
            JOptionPane.showMessageDialog(null, "Data TIDAK terubah");
        }
    }
}
