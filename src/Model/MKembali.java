/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author microsoft
 */
public class MKembali {
    String idpengembalian, idpinjam, tanggalkembali ;
    int terlambat, denda;

    public String getIdpengembalian() {
        return idpengembalian;
    }

    public void setIdpengembalian(String idpengembalian) {
        this.idpengembalian = idpengembalian;
    }

    public String getIdpinjam() {
        return idpinjam;
    }

    public void setIdpinjam(String idpinjam) {
        this.idpinjam = idpinjam;
    }

    public String getTanggalkembali() {
        return tanggalkembali;
    }

    public void setTanggalkembali(String tanggalkembali) {
        this.tanggalkembali = tanggalkembali;
    }

    public int getTerlambat() {
        return terlambat;
    }

    public void setTerlambat(int terlambat) {
        this.terlambat = terlambat;
    }

    public int getDenda() {
        return denda;
    }

    public void setDenda(int denda) {
        this.denda = denda;
    }
    
    
}
