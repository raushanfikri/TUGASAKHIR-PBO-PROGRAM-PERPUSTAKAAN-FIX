/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.MSiswa;
import Koneksi.KoneksiDB;

/**
 *
 * @author microsoft
 */
public class CSiswa {
    KoneksiDB koneksi = new KoneksiDB();

     public void simpanData(MSiswa ms) {//memanggil kelas Model kesalahan dan membuat objek km
        koneksi.koneksiDatabase();
        String query = "insert into tbl_siswa(nis, nama, kelas, jeniskelamin, kotalahir, tanggallahir, alamat, telepon, tanggalregister, ahiregister) values ('"
                +ms.getNis()+"',"
                + "'"+ms.getNama()+"','"
                + "'"+ms.getKelas()+"','"
                + "'"+ms.getJeniskelamin()+"','"
                + "'"+ms.getKotalahir()+"','"
                + "'"+ms.getTanggallahir()+"','"
                + "'"+ms.getAlamat()+"','"
                + "'"+ms.getTelepon()+"','"
                + "'"+ms.getTanggalregister()+"','"
                + "'"+ms.getAkhirregister()+"')";
        try {
            koneksi.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil disimpan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Tidak berhasil disimpan");
            System.err.println(""+e);
        }

    }
    
     public void hapusData(MSiswa ms) {
    try {
            koneksi.koneksiDatabase();
            String query = "delete from tbl_siswa where nis=('"+ms.getNis()+"')";
            koneksi.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus..");
            //koneksi.connect.close();
        } catch (SQLException e) {
            System.err.println("Error : "+e);
            JOptionPane.showMessageDialog(null, "Data TIDAK terhapus");
        }
    }
     
     public void ubahData(MSiswa ms) {
         koneksi.koneksiDatabase();
         try {
            //int id = mp.getIdpelanggan()
            String nis = ms.getNis();
            String nama = ms.getNama();
            String kelas= ms.getKelas();
            String jeniskelamin= ms.getJeniskelamin();
            String kotalahir = ms.getNis();
            String tanggallahir = ms.getNis();
            String alamat = ms.getNis();
            String telepon = ms.getNis();
            String tanggalregister = ms.getNis();
            String akhirregister = ms.getNis();
            
            String query = "update tbl_siswa "
                    
                    + "set nis=('" + nis+ "'),"
                    + "nama=('" + nama + "'),"
                    + "kelas=('"+ kelas+"'),"
                    + "jeniskelamin=('"+ jeniskelamin +"'),"
                    + "kotalahir=('"+ kotalahir +"'),"
                    + "tanggallahir=('"+ tanggallahir +"'),"
                    + "alamat=('"+ alamat +"'),"
                    + "telepon=('"+ telepon +"'),"
                    + "tanggalregister=('"+ tanggalregister +"'),"
                    + "akhirregister=('"+ akhirregister +"')"
                    + "where nis=('" + nis + "')";
            koneksi.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil DiUbah..");
        } catch (SQLException e) {
            System.err.println("Error : " + e);
            JOptionPane.showMessageDialog(null, "Data TIDAK terubah");
        }
    }

}
