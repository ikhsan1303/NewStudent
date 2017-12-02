/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxnewstudent;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Ikhsan
 */
public class Siswa {
          private SimpleStringProperty nom, nama, nisn, asal, telp, kelamin, jurusan;

    public Siswa(String nom, String nama, String nisn, String asal, String telp, String kelamin, String jurusan) {
        this.nom = new SimpleStringProperty(nom);
        this.nama = new SimpleStringProperty(nama);
        this.nisn = new SimpleStringProperty(nisn);
        this.asal = new SimpleStringProperty(asal);
        this.telp = new SimpleStringProperty(telp);
        this.kelamin = new SimpleStringProperty(kelamin);
        this.jurusan = new SimpleStringProperty(jurusan);
    }

    public String getNo() {
        return nom.get();
    }

    public void setNo(SimpleStringProperty nom) {
        this.nom = nom;
    }

    public String getNama() {
        return nama.get();
    }

    public void setNama(SimpleStringProperty nama) {
        this.nama = nama;
    }
     public String getNisn() {
        return nisn.get();
    }

    public void setNisn(SimpleStringProperty nisn) {
        this.nisn = nisn;
    }
     public String getAsal() {
        return asal.get();
    }

    public void setAsal(SimpleStringProperty asal) {
        this.asal = asal;
    }
     public String getTelp() {
        return telp.get();
    }

    public void setTelp(SimpleStringProperty telp) {
        this.telp = telp;
    }
    
    public void setKelamin(SimpleStringProperty kelamin) {
        this.kelamin = kelamin;
    }
    
    public String getKelamin() {
        return kelamin.get();
    }
    public void setJurusan(SimpleStringProperty jurusan) {
        this.jurusan = jurusan;
    }
    
    public String getJurusan() {
        return jurusan.get();
    }
}

