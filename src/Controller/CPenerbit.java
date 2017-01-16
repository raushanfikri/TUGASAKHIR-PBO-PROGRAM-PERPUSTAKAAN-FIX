/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.MPenerbit;
import Koneksi.KoneksiDB;
/**
 *
 * @author microsoft
 */
public class CPenerbit {
     KoneksiDB koneksi = new KoneksiDB();

    public void simpanData(MPenerbit mp) {//memanggil kelas Model kesalahan dan membuat objek km
        koneksi.koneksiDatabase();
        String query = "insert into tbl_penerbit(kodepenerbit, namapenerbit, alamat, kota,nope) values ('"
                +mp.getKodepenerbit()+"',"
                + "'"+mp.getNamapenerbit()+"','"
                + "'"+mp.getAlamat()+"','"
                + "'"+mp.getKota()+"','"
                + "'"+mp.getNope()+"')";
        try {
            koneksi.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil disimpan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Tidak berhasil disimpan");
            System.err.println(""+e);
        }

    }
    
     public void hapusData(MPenerbit mp) {
    try {
            koneksi.koneksiDatabase();
            String query = "delete from tbl_penerbit where kodepenerbit=('"+mp.getKodepenerbit()+"')";
            koneksi.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus..");
            //koneksi.connect.close();
        } catch (SQLException e) {
            System.err.println("Error : "+e);
            JOptionPane.showMessageDialog(null, "Data TIDAK terhapus");
        }
    }
     
     public void ubahData(MPenerbit mp) {
         koneksi.koneksiDatabase();
         try {
            //int id = mp.getIdpelanggan()
            String kodepenerbit = mp.getKodepenerbit();
            String namapenerbit = mp.getNamapenerbit();
            String alamat= mp.getAlamat();
            String kota= mp.getKota();
            String nope = mp.getNope();
           
            
            String query = "update tbl_penerbit "
                    
                    + "set kodepenerbit=('" + kodepenerbit+ "'),"
                    + "namapenerbit=('" + namapenerbit + "'),"
                    + "alamat=('"+ alamat+"'),"
                    + "kota=('"+ kota +"'),"
                    + "nope=('"+ nope +"')"
                    + "where kodepenerbit=('" +kodepenerbit + "')";
            koneksi.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil DiUbah..");
        } catch (SQLException e) {
            System.err.println("Error : " + e);
            JOptionPane.showMessageDialog(null, "Data TIDAK terubah");
        }
    }
}
