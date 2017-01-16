/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.MBuku;
import Koneksi.KoneksiDB;


/**
 *
 * @author microsoft
 */
public class CBuku {
    KoneksiDB koneksi = new KoneksiDB();

    public void simpanData(MBuku mb) {//memanggil kelas Model kesalahan dan membuat objek km
        koneksi.koneksiDatabase();
        String query = "insert into tbl_buku(kodebuku,kodejenis,kodekategori,judul,pengarang,kodepenerbit,tahun,jumlahbuku) values ('"
                +mb.getKodebuku()+"',"
                + "'"+mb.getKodejenis()+"','"
                + "'"+mb.getKodekategori()+"','"
                + "'"+mb.getJudul()+"','"
                + "'"+mb.getPengarang()+"','"
                + "'"+mb.getKodepenerbit()+"','"
                + "'"+mb.getTahun()+"','"
                + "'"+mb.getJumlahbuku()+"')";
        try {
            koneksi.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil disimpan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Tidak berhasil disimpan");
            System.err.println(""+e);
        }

    }
    
     public void hapusData(MBuku mb) {
    try {
            koneksi.koneksiDatabase();
            String query = "delete from tbl_buku where kodebuku=('"+mb.getKodebuku()+"')";
            koneksi.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus..");
            //koneksi.connect.close();
        } catch (SQLException e) {
            System.err.println("Error : "+e);
            JOptionPane.showMessageDialog(null, "Data TIDAK terhapus");
        }
    }
     
     public void ubahData(MBuku mb) {
         koneksi.koneksiDatabase();
         try {
            //int id = mp.getIdpelanggan();
            String kodebuku = mb.getKodebuku();
            String kodejenis = mb.getKodejenis();
            String kodekategori= mb.getKodekategori();
            String judul= mb.getJudul();
            String pengarang = mb.getPengarang();
            String kodepenerbit = mb.getKodepenerbit();
            String tahun = mb.getTahun();
            int jumlahbuku = mb.getJumlahbuku();
            
            String query = "update tbl_buku "
                    
                    + "set kodebuku=('" + kodebuku+ "'),"
                    + "kodejenis=('" + kodejenis + "'),"
                    + "kodekategori=('"+ kodekategori+"'),"
                    + "judul=('"+ judul +"'),"
                    + "pengarang=('"+pengarang+"'),"
                    + "kodepenerbit=('"+kodepenerbit+"'),"
                    + "tahun=('"+tahun+"'),"
                    + "jumlahbuku=('"+jumlahbuku+"')"
                    + "where kodebuku=('" + kodebuku + "')";
            koneksi.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil DiUbah..");
        } catch (SQLException e) {
            System.err.println("Error : " + e);
            JOptionPane.showMessageDialog(null, "Data TIDAK terubah");
        }
    }
}
