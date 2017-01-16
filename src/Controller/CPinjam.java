/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.MPinjam;
import Koneksi.KoneksiDB;
/**
 *
 * @author microsoft
 */
public class CPinjam {
     KoneksiDB koneksi = new KoneksiDB();

    public void simpanData(MPinjam mPI) {//memanggil kelas Model kesalahan dan membuat objek km
        koneksi.koneksiDatabase();
        String query = "insert into tbl_pinjam1(id_pinjam, nis, nama, kodebuku, judul, tanggalpinjam, tanggalkembali) values ('"
                +mPI.getIdpinjam()+"',"
                + "'"+mPI.getNis()+"','"
                + "'"+mPI.getNama()+"','"
                + "'"+mPI.getKodebuku()+"','"
                + "'"+mPI.getJudul()+"','"
                + "'"+mPI.getTanggalpinjam()+"','"
                + "'"+mPI.getTanggalkembali()+"')";
        try {
            koneksi.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil disimpan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Tidak berhasil disimpan");
            System.err.println(""+e);
        }

    }
    
    
    public void hapusData(MPinjam mPI) {
    try {
            koneksi.koneksiDatabase();
            String query = "delete from tbl_pinjam1 where id_pinjam=('"+mPI.getIdpinjam()+"')";
            koneksi.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus..");
            //koneksi.connect.close();
        } catch (SQLException e) {
            System.err.println("Error : "+e);
            JOptionPane.showMessageDialog(null, "Data TIDAK terhapus");
        }
    }
    
    public void ubahData(MPinjam mPI) {
         koneksi.koneksiDatabase();
         try {
            //int id = mp.getIdpelanggan();
            String id_pinjam = mPI.getIdpinjam();
            String nis = mPI.getNis();
            String nama= mPI.getNama();
            String kodebuku= mPI.getKodebuku();
            String judul = mPI.getJudul();
            String tanggalpinjam = mPI.getTanggalpinjam();
            String tanggalkembali = mPI.getTanggalkembali();
            
            
            String query = "update tbl_pinjam1 "
                    
                    + "set id_pinjam=('" + id_pinjam+ "'),"
                    + "nis=('" + nis + "'),"
                    + "nama=('"+ nama+"'),"
                    + "kodebuku=('"+ kodebuku+"'),"
                    + "judul('"+judul+"'),"
                    + "tanggalpinjam =('"+tanggalpinjam+"'),"
                    + "tanggalkembali=('"+tanggalkembali+"')"
                    + "where id_pinjam=('" + id_pinjam + "')";
            koneksi.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil DiUbah..");
        } catch (SQLException e) {
            System.err.println("Error : " + e);
            JOptionPane.showMessageDialog(null, "Data TIDAK terubah");
        }
    }
}
