/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxnewstudent;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Ikhsan
 */
public class FXMLDaftarController implements Initializable {
      @FXML
    private JFXTextField nama;

    @FXML
    private JFXTextField nisn;

    @FXML
    private JFXTextField asal;

    @FXML
    private JFXTextField telp;
    
    @FXML
    private JFXRadioButton jk1;

    @FXML
    private ToggleGroup jeniskelamin;

    @FXML
    private JFXRadioButton jk2;

    @FXML
    private JFXRadioButton jur1;

    @FXML
    private ToggleGroup jurusan;

    @FXML
    private JFXRadioButton jur2;

    @FXML
    void daftar(ActionEvent event) {
        
        int valid; //sing iki gawe tanda wes valid opo durung
        if(nama.getText().equals("") || nisn.getText().equals("") || asal.getText().equals("") || telp.getText().equals("")){
            valid = 0; // 0 iku gawe tanda lak durung falid, soale nde if iku kondisi e nggolek i lak onok sing kosong opo gk
            if (!jk2.isSelected() || !jk1.isSelected() || !jur1.isSelected() || !jur2.isSelected()){
                valid = 0;
            }
        
        }else{
            valid = 1; // 1 berarti wes gk onok sing kosong
        }
        if(valid == 0){ // lak 0 kan berarti onok sing kosong, ndek kene digolek i opo sing kosong
        if(nama.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong !");
        }else
        if(nisn.getText().equals("")){
            JOptionPane.showMessageDialog(null, "NISN tidak boleh kosong !");
        }else
        if(asal.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Asal tidak boleh kosong !");
        }else
        if(telp.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nomor Telepon tidak boleh kosong !");
        }else
        if(!jk2.isSelected() && !jk1.isSelected()){
            JOptionPane.showMessageDialog(null, "Jenis Kelamin tidak boleh kosong !");
        }else
        if(jur2.isSelected() == false && jur1.isSelected() == false){
            JOptionPane.showMessageDialog(null, "Jurusan tidak boleh kosong !");
        }
        }else{ //ndek kene menjalakan perintah, soale wes gk onok sing kosong
            
        String kelamin = null, JURUSAN = null;
        if(jk1.isSelected()){
            kelamin = "Laki - Laki";
        } else if(jk2.isSelected()){
            kelamin = "Perempuan";
        }
        
        if(jur1.isSelected()){
            JURUSAN = "RPL";
        } else if (jur2.isSelected()){
            JURUSAN = "TKJ";
        }
        Connection con=new koneksi().getConnection();
   Connection connection;
   PreparedStatement st;
        try{ 
       connection =DriverManager.getConnection("jdbc:mysql://localhost/newstudent?zeroDate TimeBehavior=convertToNull", "root", "");
    st=connection.prepareStatement("INSERT INTO `tb_siswa`(`nama_siswa`, `nisn`, `asal`, `telp`, `jkelamin`, `jurusan`) values(?,?,?,?,?,?)");
    st.setString(1,nama.getText());
    st.setString(2,nisn.getText());
    st.setString(3,asal.getText());
    st.setString(4,telp.getText());
    st.setString(5, kelamin);
    st.setString(6, JURUSAN);
        
        st.execute();
        JOptionPane.showMessageDialog(null, "Terima Kasih Sudah Mendaftar");
        
   }catch(Exception e){
       JOptionPane.showMessageDialog(null, e);
   }
        }
        
        nama.setText("");
        nisn.setText("");
        asal.setText("");
        telp.setText("");

    }

    @FXML
    void exit(ActionEvent event) {
        System.exit(0);

    }

    @FXML
    void nextpage(ActionEvent event) throws IOException {
        // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLview.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 960, 400);
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("New Student");
            stage.show();
            stage.setResizable(false);

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
