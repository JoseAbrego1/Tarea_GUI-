/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pmp.javafx101;

import com.pmp.dao.Persona;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * 
 */
public class FrmPersonaController implements Initializable {

    @FXML
    private TextField txtCuenta;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtGrado;
    @FXML
    private TextField txtEdad;
    @FXML
    private TextField txtTelefono;
    @FXML
    private Button btnAceptar;
    @FXML
    private Button btnCancelar;
    /**
     * Initializes the controller class.
     */
    
    boolean confirmAction;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void btnAceptar_click(ActionEvent event) {
        this.confirmAction = true;
        App.closeModal(event);
    }

    @FXML
    private void btnCancelar_click(ActionEvent event) {
        this.confirmAction = false;
        App.closeModal(event);
    }

    
    private Persona _Persona;
    
    
    public void setPersonaObject( Persona cliente) {
        _Persona = cliente;
        refreshUX();
    }
    
    private void refreshUX(){
        txtCuenta.setText(String.valueOf(_Persona.getId()));
        txtNombre.setText(_Persona.getNombre());
        txtGrado.setText(_Persona.getApellido());
        txtTelefono.setText(String.valueOf(_Persona.getEstatura()));
        txtEdad.setText(String.valueOf(_Persona.getPeso())); 
    }
    
    public void setMode(String mode) {
        switch (mode) {
            case "INS":
                txtTelefono.setText("");
                txtEdad.setText("");
                txtCuenta.setEditable(false);
                break;
            case "UPD":
                txtCuenta.setEditable(false);
                break;
            case "DEL", "DSP":
                txtCuenta.setEditable(false);
                txtNombre.setEditable(false);
                txtGrado.setEditable(false);
                txtTelefono.setEditable(false);
                txtEdad.setEditable(false);
                if(mode == "DSP") btnAceptar.setVisible(false);
                break;
        }
    }
    
    public Persona getPersonaObject(){
        refreshObjFromUx();
        return _Persona;
    }
    private void refreshObjFromUx(){
        _Persona.setId(Integer.parseInt(txtCuenta.getText()));
        _Persona.setNombre(txtNombre.getText());
        _Persona.setApellido(txtGrado.getText());
        _Persona.setEstatura(Double.parseDouble(txtTelefono.getText()));
        _Persona.setPeso(Double.parseDouble(txtEdad.getText()));
    }
    public boolean isConfirmAction() {
        return confirmAction;
    }

   
}
