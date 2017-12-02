/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxnewstudent;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Ikhsan
 */
public class koneksi {
     Connection koneksi;
    public Connection getConnection(){
        try {
           koneksi=DriverManager.getConnection("jdbc:mysql://localhost/newstudent","root","");
           JOptionPane.showMessageDialog(null,"Tersimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi ke database GAGAL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        return koneksi;
    }
    
}
