/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author microsoft
 */
public class KoneksiDB {
   public Connection connect;
    public Statement state;
    public ResultSet res;
    String namaDatabase = "jdbc:mysql://localhost:3306/db_perpustakaan";
    public void koneksiDatabase(){
        try {
            connect = DriverManager.getConnection(namaDatabase,"root","");//nama database, username database, password database
            System.out.println("Koneksi Tidak Bermasalah");
            state = connect.createStatement();
        } catch (SQLException ex) {
             System.err.println("Cek url, username host dan password host");
             System.err.println("SQLException:"+ex.getMessage());
        }
     }

    public PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
}
