package com.pmp.javafx101;
import com.pmp.dao.Persona;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;


public class PersonaAdapter
{

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre.get();
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String _Nombre) {
        this.Nombre.set(_Nombre);
    }

    /**
     * @return the Apellido
     */
    public String getApellido() {
        return Apellido.get();
    }

    /**
     * @param Apellido the Apellido to set
     */
    public void setApellido (String _Apellido) {
        this.Apellido.set(_Apellido);
    }

    /**
     * @return the Estatura
     */
    public Double getEstatura() {
        return Estatura.get();
    }

    /**
     * @param Estatura the Estatura to set
     */
    public void setEstatura(Double _Estatura) {
        this.Estatura.set(_Estatura);
    }

    /**
     * @return the Peso
     */
    public Double getPeso() {
        return Peso.get();
    }

    /**
     * @param Peso the Peso to set
     */
    public void setPeso(Double Peso) {
        this.Peso.get();
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id.get();
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id.get();
    }


    
    private Persona _Persona;
    
    
    public Persona getPersona() {
        _Persona.setId(id.get()); 
        _Persona.setNombre(Nombre.get());
        _Persona.setApellido(Apellido.get());
        _Persona.setEstatura(Estatura.get());
        _Persona.setPeso(Peso.get());
        return this._Persona;
    }
    
    public PersonaAdapter(){
        this._Persona = new Persona();
        Nombre = new SimpleStringProperty("");
        Apellido = new SimpleStringProperty("");
        Estatura =new SimpleDoubleProperty(0);
        Peso = new SimpleDoubleProperty(0);

    }
    public PersonaAdapter(Persona _Persona){
        this._Persona = _Persona;
        id = new SimpleIntegerProperty(0);
        Nombre = new SimpleStringProperty("");
        Apellido = new SimpleStringProperty("");
        Estatura = new SimpleDoubleProperty(0);
        Peso = new SimpleDoubleProperty(0);
        
        id.set(_Persona.getId());
        Nombre.set(_Persona.getNombre());
        Apellido.set(_Persona.getApellido());
        Estatura.set(_Persona.getEstatura());
        Peso.set(_Persona.getPeso());

    }
    
    
    private SimpleStringProperty Nombre;
    private SimpleStringProperty Apellido;
    private SimpleDoubleProperty Estatura;
    private SimpleDoubleProperty Peso;
    private SimpleIntegerProperty id;
}
