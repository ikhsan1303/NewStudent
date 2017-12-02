/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxnewstudent;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Ikhsan
 */
public class FXMLAdminController implements Initializable {
    
     @FXML
    private JFXTextField NISN;

    @FXML
    private JFXTextField Nisn;

    @FXML
    private JFXTextField Nama;

    @FXML
    private JFXTextField Asal;

    @FXML
    private JFXTextField Telp;

    @FXML
    private JFXRadioButton jk1;

    @FXML
    private ToggleGroup jkelamin;

    @FXML
    private JFXRadioButton jk2;

    @FXML
    private JFXTextField Jurusan;
    
    @FXML
    private TableView<Siswa> tabel;

    @FXML
    private TableColumn<Siswa, String> nisn;

    @FXML
    private TableColumn<Siswa, String> nama;

    @FXML
    private TableColumn<Siswa, String> asal;

    @FXML
    private TableColumn<Siswa, String> telpon;

    @FXML
    private TableColumn<Siswa, String> kelamin;

    @FXML
    private TableColumn<Siswa, String> jurusan;
    private ObservableList<Siswa> data;

   
    @FXML
    void hapus(ActionEvent event) {
        Connection con=new koneksi().getConnection();
   Connection connection;
   PreparedStatement st;
        try{ 
       connection =DriverManager.getConnection("jdbc:mysql://localhost/newstudent?zeroDate TimeBehavior=convertToNull", "root", "");
    st=connection.prepareStatement("DELETE FROM `tb_siswa` WHERE `nisn` = ?");
    st.setString(1,NISN.getText());
    
        
        st.execute();
        JOptionPane.showMessageDialog(null, "Data sudah Dihapus");
        
   }catch(Exception e){
       JOptionPane.showMessageDialog(null, e);
   }

    }

    @FXML
    void refresh(ActionEvent event) {
        try {
            java.sql.Connection con = Config.configDB();
            data = FXCollections.observableArrayList();

            ResultSet rs = con.createStatement().executeQuery("select * from tb_siswa");

            while (rs.next()) {
                data.add(new Siswa(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
            }
            JOptionPane.showMessageDialog(null, "Data Sudah Diperbarui");

        } catch (SQLException ex) {
           System.out.println("Erorr"+ex);
           
        }
        nisn.setCellValueFactory(new PropertyValueFactory<>("nisn"));
        nama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        asal.setCellValueFactory(new PropertyValueFactory<>("asal"));
        telpon.setCellValueFactory(new PropertyValueFactory<>("telp"));
        kelamin.setCellValueFactory(new PropertyValueFactory<>("kelamin"));
        jurusan.setCellValueFactory(new PropertyValueFactory<>("jurusan"));

        
        tabel.setItems(null);
        tabel.setItems(data);

    }

    @FXML
    void update(ActionEvent event) {
        String Kelamin = null;
        if(jk1.isSelected()){
            Kelamin = "Laki - Laki";
        } else if(jk2.isSelected()){
            Kelamin = "Perempuan";
        }
        Connection con=new koneksi().getConnection();
   Connection connection;
   PreparedStatement st;
        try{ 
       connection =DriverManager.getConnection("jdbc:mysql://localhost/newstudent?zeroDate TimeBehavior=convertToNull", "root", "");
    st=connection.prepareStatement("UPDATE `tb_siswa` SET `nama_siswa`= ?,`asal`= ?,`telp`= ?,`jkelamin`=? ,`jurusan`= ? WHERE `nisn` = ?");
    st.setString(1,Nama.getText());
    st.setString(2,Asal.getText());
    st.setString(3,Telp.getText());
    st.setString(4,Kelamin);
    st.setString(5, Jurusan.getText());
    st.setString(6, NISN.getText());
        
        st.execute();
        JOptionPane.showMessageDialog(null, "Data sudah Diupdate");
        
   }catch(Exception e){
       JOptionPane.showMessageDialog(null, e);
   }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            java.sql.Connection con = Config.configDB();
            data = FXCollections.observableArrayList();

            ResultSet rs = con.createStatement().executeQuery("select * from tb_siswa");

            while (rs.next()) {
                data.add(new Siswa(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
            }

        } catch (SQLException ex) {
           System.out.println("Erorr"+ex);
           
        }
        nisn.setCellValueFactory(new PropertyValueFactory<>("nisn"));
        nama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        asal.setCellValueFactory(new PropertyValueFactory<>("asal"));
        telpon.setCellValueFactory(new PropertyValueFactory<>("telp"));
        kelamin.setCellValueFactory(new PropertyValueFactory<>("kelamin"));
        jurusan.setCellValueFactory(new PropertyValueFactory<>("jurusan"));

        
        tabel.setItems(null);
        tabel.setItems(data);
    }    
    
}
