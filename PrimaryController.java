package com.pmp.javafx101;

import com.pmp.dao.Persona;
import com.pmp.dao.PersonaMod;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PrimaryController implements Initializable
{
    int contador = 0;
        
    enum FormMode {
        INS,
        UPD,
        DEL,
        DSP
    }
    
    @FXML
    private TableView tblAlumnos;
    @FXML
    private TableColumn clmNombre;
    @FXML
    private TableColumn clmGrado;
    @FXML
    private TableColumn clmEdad;
    @FXML
    private TableColumn clmCuenta;
    @FXML
    private TableColumn clmTelefono;
    private ObservableList<PersonaAdapter> listaDePersonas;
    private PersonaMod PersonaMod; //Ready
    @FXML
    private Button btnNuevo;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnMostrar;
    @FXML
    private Button btnEliminar;
    
    FormMode mode;
    
    
    private void reloadData(){
        listaDePersonas = FXCollections.observableArrayList(
                PersonaAdapterFactory.getFromPersonaArrayList(
                        PersonaMod.obtenerPersona()
                ));
        this.tblAlumnos.getItems().clear();
        this.tblAlumnos.getItems().addAll(listaDePersonas);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        PersonaMod = new PersonaMod();
        
        this.clmCuenta.setCellValueFactory(new PropertyValueFactory<PersonaAdapter, String>("Id"));
        this.clmNombre.setCellValueFactory(new PropertyValueFactory<PersonaAdapter, String>("Nombre"));
        this.clmGrado.setCellValueFactory(new PropertyValueFactory<PersonaAdapter, String>("Apellido"));
        this.clmTelefono.setCellValueFactory(new PropertyValueFactory<PersonaAdapter, String>("Estatura"));
        this.clmEdad.setCellValueFactory(new PropertyValueFactory<PersonaAdapter, String>("Peso"));
        
        reloadData();
    }
    
    
    
    private Persona loadPersonaFrm(Persona Perso) throws IOException {
        try {
            FXMLLoader win = App.getFXMLLoader("FrmPersona");
            Parent winObject = win.load();
            FrmPersonaController PersonaWin = (FrmPersonaController) win.getController();
            PersonaWin.setPersonaObject(Perso);
            PersonaWin.setMode(mode.name());
            App.loadFXMLModal(winObject);
            if (PersonaWin.isConfirmAction()){
                return PersonaWin.getPersonaObject();
            }
            return null;
        } catch (IOException ex) {
            System.err.println(ex);
            return null;
        }
                
    }
    
    @FXML
    private void btnNuevo_click(ActionEvent event) {
        try {
            mode = FormMode.INS;
            Persona formData = loadPersonaFrm(new Persona());
            if (formData != null) {
                PersonaMod.agregarPersona(formData);
                reloadData();
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    
    @FXML
    private void btnEditar_click(ActionEvent event) {
         try {
            mode = FormMode.UPD;
            Persona formData = loadPersonaFrm(
                    ((PersonaAdapter)tblAlumnos
                            .getSelectionModel()
                            .getSelectedItem()
                    ).getPersona()
            );
            if (formData != null) {
                PersonaMod.actualizarPersona(formData);
                reloadData();
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    @FXML
    private void btnMostrar_click(ActionEvent event) {
        try {
            mode = FormMode.DSP;
            Persona formData = loadPersonaFrm(
                    ((PersonaAdapter)tblAlumnos
                            .getSelectionModel()
                            .getSelectedItem()
                    ).getPersona()
            );
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    @FXML
    private void btnEliminar_click(ActionEvent event) {
        try {
            mode = FormMode.DEL;
            Persona formData = loadPersonaFrm(
                    ((PersonaAdapter)tblAlumnos
                            .getSelectionModel()
                            .getSelectedItem()
                    ).getPersona()
            );
            if (formData != null) {
                PersonaMod.eliminarPersona(formData.getId());
                reloadData();
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

}
