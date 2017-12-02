/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxnewstudent;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Ikhsan
 */
public class FXMLviewController implements Initializable {

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
    void backdaftar(ActionEvent event) throws IOException {
         // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLDaftar.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("New Student");
            stage.show();
            stage.setResizable(false);
    }

    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
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
